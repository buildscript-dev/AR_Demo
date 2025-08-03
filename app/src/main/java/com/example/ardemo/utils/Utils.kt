package com.example.ardemo.utils

import androidx.compose.ui.graphics.Color
import com.google.android.filament.Engine
import com.google.ar.core.Anchor
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.loaders.MaterialLoader
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.node.CubeNode
import io.github.sceneview.node.ModelNode

object Utils {
    val protos = mapOf(
        "Cube" to "cube.glb",
        "Triangle" to "triangle.glb",
        "Soccer Ball" to "soccer_ball.glb",
        "Cake" to "cake.glb",
        "Meal" to "meal.glb",
        "Ironman" to "iron_man.glb",
        "Spiderman" to "spiderman.glb",
        "Dr Strange" to "dr_strange.glb",
        "Poke Ball" to "poke_ball.glb",
        "Pikachu" to "pikachu.glb",
        "Charmandal" to "charmandal.glb",
        "Vintage Car" to "car.glb",
        "Lamborghini" to "lamborghini.glb",
        "Warhorn" to "warnhorn.glb",
        )


    fun getModelForProto(proto: String): String {
        val modelName = protos[proto] ?: error("Model not found")
        return "models/$modelName"
    }

    fun createAnchorNode(
        engine: Engine,
        modelLoader: ModelLoader,
        materialLoader: MaterialLoader,
        modelInstance: MutableList<ModelInstance>,
        anchor: Anchor,
        model: String
    ): AnchorNode {
        val anchorNode = AnchorNode(engine = engine, anchor = anchor)
        val modelNode = ModelNode(
            modelInstance = modelInstance.apply {
                if (isEmpty()) {
                    this += modelLoader.createInstancedModel(model, 10)
                }
            }
//                .removeAt(modelInstance.lastIndex),
                .removeLast(),
            scaleToUnits = 0.2f
        ).apply {
            isEditable = true
        }

        val boundingBox = CubeNode(
            engine = engine,
            size = modelNode.extents,
            center = modelNode.center,
            materialInstance = materialLoader.createColorInstance(Color.White)
        ).apply {
            isVisible = false
        }
        modelNode.addChildNode(boundingBox)
        anchorNode.addChildNode(modelNode)
        listOf(modelNode, anchorNode).forEach {
            it.onEditingChanged = { editingTransforms ->
                boundingBox.isVisible = editingTransforms.isNotEmpty()
            }
        }
        return anchorNode

    }

    fun randomModel(): Pair<String, String> {
        val randomIndex = (0 until protos.size).random()
        val proto = protos.keys.elementAt(randomIndex)
        return Pair(proto, getModelForProto(proto))
    }
}