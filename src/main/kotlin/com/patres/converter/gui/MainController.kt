package com.patres.converter.gui

import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXComboBox
import com.jfoenix.controls.JFXTextField
import com.patres.converter.GeoType
import com.patres.converter.MainApp
import com.patres.converter.geo.trkpt.TrkptLoader
import com.patres.converter.geo.wpt.WptLoader
import com.patres.converter.gui.dialog.HandlerDialog
import javafx.fxml.FXML
import javafx.scene.layout.StackPane
import javafx.stage.FileChooser
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileWriter
import java.io.IOException


class MainController {


    companion object {
        private val LOGGER = LoggerFactory.getLogger(MainController::class.java)
    }

    // ================================================================================
    // Components
    // ================================================================================
    @FXML
    lateinit var root: StackPane

    @FXML
    private lateinit var typeComboBox: JFXComboBox<GeoType>

    @FXML
    private lateinit var filePathField: JFXTextField

    @FXML
    private lateinit var convertButton: JFXButton


    // ================================================================================
    // Configuration methods
    // ================================================================================
    fun initialize() {
        typeComboBox.items.addAll(GeoType.values())
        typeComboBox.value = GeoType.WPT
        convertButton.disableProperty().set(true)
        filePathField.textProperty().addListener({ _, _, newValue -> convertButton.disableProperty().set(!fileExist(newValue)) })

    }

    fun browseFile() {
        val fileChooser = FileChooser()
        fileChooser.title = "Wybierz plik"
        val file = fileChooser.showOpenDialog(MainApp.mainStage)
        if (file != null) {
            filePathField.text = file.absolutePath
        }
    }

    fun convert() {
        val pathTarget = filePathField.text
        val extFilter = FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt")
        val fileChooser = FileChooser()
        fileChooser.extensionFilters.add(extFilter)
        fileChooser.initialDirectory = File(pathTarget).parentFile
        val file = fileChooser.showSaveDialog(MainApp.mainStage)

        if (file != null) {

            saveFile(getContent(typeComboBox.value, pathTarget), file)
            HandlerDialog("Plik przkonwertowany").show()
        }
    }

    private fun saveFile(content: String, file: File) {
        try {
            val fileWriter: FileWriter?
            fileWriter = FileWriter(file)
            fileWriter.write(content)
            fileWriter.close()
        } catch (ex: IOException) {
            LOGGER.error("IOException: {}", ex)
        }
    }

    private fun getContent(type: GeoType, path: String): String {
        val loader = when (type) {
            GeoType.WPT -> WptLoader(path)
            GeoType.TRKPT -> TrkptLoader(path)
        }
        return loader.getContent()
    }


    private fun fileExist(file: String): Boolean {
        return File(file).exists()
    }
}