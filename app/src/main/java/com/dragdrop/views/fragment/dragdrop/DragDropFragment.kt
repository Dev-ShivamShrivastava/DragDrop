package com.dragdrop.views.fragment.dragdrop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dragdrop.R
import com.dragdrop.adapters.DragAdapter
import com.dragdrop.adapters.DropAdapter
import com.dragdrop.databinding.FragmentDragDropBinding
import com.dragdrop.interfaces.OnCallBackListener
import com.dragdrop.models.DragModel
import com.dragdrop.models.DropModel
import com.dragdrop.utils.playName

class DragDropFragment : Fragment(), OnCallBackListener {

    val binding by lazy {
        FragmentDragDropBinding.inflate(layoutInflater).apply {
            model = viewModel
        }
    }

    private val viewModel: DragDropVM by viewModels()

    private val dropAdapter by lazy { DropAdapter() }
    private val dragAdapter by lazy { DragAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDrop.adapter = dropAdapter
        binding.rvDrag.adapter = dragAdapter
        viewModel.type.set(arguments?.getString("type"))
        requireContext().playName(viewModel.type.get()?:"")
        checkType()
    }

    private fun checkType() {
        val (dragList: List<DragModel>, dropList: List<DropModel>) = when (viewModel.type.get()) {
            "Animals" -> {
                arrayListOf<DragModel>(
                    DragModel(
                        name = "Elephant",
                        image = R.drawable.elephant,
                        typeName = R.raw.elephant
                    ),
                    DragModel(name = "Horse", R.drawable.horse, typeName = R.raw.horse),
                    DragModel(name = "Lion", R.drawable.lion, typeName = R.raw.animals),
                    DragModel(name = "Tiger", R.drawable.tiger, typeName = R.raw.tiger),
                    DragModel(name = "Monkey", R.drawable.monkey, typeName = R.raw.monkey),
                    DragModel(name = "Fox", R.drawable.fox, typeName = R.raw.fox),
                    DragModel(name = "Dog", R.drawable.dog, typeName = R.raw.dog),
                    DragModel(name = "Cat", R.drawable.cat, typeName = R.raw.cat),
                    DragModel(name = "Goat", R.drawable.goat, typeName = R.raw.goat),
                    DragModel(name = "Pig", R.drawable.pig, typeName = R.raw.pig),
                    DragModel(name = "Giraffe", R.drawable.giraffe, typeName = R.raw.giraffe)
                ) to
                        arrayListOf<DropModel>(
                            DropModel(name = "Elephant"),
                            DropModel(name = "Horse"),
                            DropModel(name = "Lion"),
                            DropModel(name = "Tiger"),
                            DropModel(name = "Monkey"),
                            DropModel(name = "Fox"),
                            DropModel(name = "Dog"),
                            DropModel(name = "Cat"),
                            DropModel(name = "Goat"),
                            DropModel(name = "Pig"),
                            DropModel(name = "Giraffe"),
                        )
            }
            "Fruits" -> {
                arrayListOf<DragModel>(
                    DragModel(name = "Apple", R.drawable.apple, typeName = R.raw.apple),
                    DragModel(name = "Pineapple", R.drawable.pineapple, typeName = R.raw.pineapple),
                    DragModel(name = "Banana", R.drawable.banana, typeName = R.raw.banana),
                    DragModel(name = "Papaya", R.drawable.papaya, typeName = R.raw.papaya),
                    DragModel(name = "Grape", R.drawable.grape, typeName = R.raw.grape),
                    DragModel(name = "Mango", R.drawable.mango, typeName = R.raw.mango),
                    DragModel(name = "Orange", R.drawable.orange, typeName = R.raw.orange),
                    DragModel(name = "Pomegranate", R.drawable.pomegranate, typeName = R.raw.pomegranate),
                    DragModel(name = "Strawberry", R.drawable.strawberry, typeName = R.raw.strawberry),
                    DragModel(name = "Watermelon", R.drawable.watermelon, typeName = R.raw.watermelon),
                ) to
                        arrayListOf<DropModel>(
                            DropModel(name = "Apple"),
                            DropModel(name = "Pineapple"),
                            DropModel(name = "Banana"),
                            DropModel(name = "Papaya"),
                            DropModel(name = "Grape"),
                            DropModel(name = "Mango"),
                            DropModel(name = "Orange"),
                            DropModel(name = "Pomegranate"),
                            DropModel(name = "Strawberry"),
                            DropModel(name = "Watermelon"),
                        )
            }
            "Insects" -> {
                arrayListOf<DragModel>(
                    DragModel(name = "Ant", R.drawable.ant, typeName = R.raw.ant),
                    DragModel(name = "Bee", R.drawable.bee, typeName = R.raw.bee),
                    DragModel(name = "Beetle", R.drawable.beetle, typeName = R.raw.beetle),
                    DragModel(name = "Butterfly", R.drawable.butterfly, typeName = R.raw.butterfly),
                    DragModel(name = "Cockroach", R.drawable.cockroach, typeName = R.raw.cockroach),
                    DragModel(name = "Caterpillar", R.drawable.caterpillar, typeName = R.raw.caterpillar),
                    DragModel(name = "Centipede", R.drawable.centipede, typeName = R.raw.centipede),
                    DragModel(name = "Dragonfly", R.drawable.dragonfly, typeName = R.raw.dragonfly),
                    DragModel(name = "Grasshopper", R.drawable.grasshopper, typeName = R.raw.grasshopper),
                    DragModel(name = "Mosquito", R.drawable.mosquito, typeName = R.raw.mosquito),
                ) to
                        arrayListOf<DropModel>(
                            DropModel(name = "Ant"),
                            DropModel(name = "Bee"),
                            DropModel(name = "Beetle"),
                            DropModel(name = "Butterfly"),
                            DropModel(name = "Cockroach"),
                            DropModel(name = "Caterpillar"),
                            DropModel(name = "Centipede"),
                            DropModel(name = "Dragonfly"),
                            DropModel(name = "Grasshopper"),
                            DropModel(name = "Mosquito"),
                        )
            }
            "Flowers" -> {
                arrayListOf<DragModel>(
                    DragModel(name = "Rose", R.drawable.rose, typeName = R.raw.rose),
                    DragModel(name = "Orchid", R.drawable.orchid, typeName = R.raw.orchid),
                    DragModel(name = "Daisy", R.drawable.daisy, typeName = R.raw.daisy),
                    DragModel(name = "Hibiscus", R.drawable.hibiscus, typeName = R.raw.hibiscus),
                    DragModel(name = "Sunflower", R.drawable.sunflower, typeName = R.raw.sunflower),
                    DragModel(name = "Lotus", R.drawable.lotus, typeName = R.raw.lotus),
                    DragModel(name = "Tulip", R.drawable.tulip, typeName = R.raw.tulip)
                ) to
                        arrayListOf<DropModel>(
                            DropModel(name = "Rose"),
                            DropModel(name = "Orchid"),
                            DropModel(name = "Daisy"),
                            DropModel(name = "Hibiscus"),
                            DropModel(name = "Sunflower"),
                            DropModel(name = "Lotus"),
                            DropModel(name = "Tulip")
                        )
            }
            "Birds" -> {
                arrayListOf<DragModel>(
                    DragModel(name = "Crow", R.drawable.ic_crow, typeName = R.raw.crow),
                    DragModel(name = "Duck", R.drawable.ic_duck, typeName = R.raw.duck),
                    DragModel(name = "Pigeon", R.drawable.ic_pigeon, typeName = R.raw.pigeon),
                    DragModel(name = "Hen", R.drawable.ic_hen, typeName = R.raw.hen),
                    DragModel(name = "Eagle", R.drawable.ic_eagle, typeName = R.raw.eagle),
                    DragModel(name = "Peacock", R.drawable.ic_peacock, typeName = R.raw.peacock),
                    DragModel(name = "Owl", R.drawable.ic_owl, typeName = R.raw.owl),
                    DragModel(name = "Parrot", R.drawable.ic_parrot, typeName = R.raw.parrot),
                    DragModel(name = "Swan", R.drawable.ic_swan, typeName = R.raw.swan),
                    DragModel(name = "Penguin", R.drawable.ic_penguin, typeName = R.raw.penguin),
                ) to
                arrayListOf<DropModel>(
                    DropModel(name = "Crow"),
                    DropModel(name = "Duck"),
                    DropModel(name = "Pigeon"),
                    DropModel(name = "Hen"),
                    DropModel(name = "Eagle"),
                    DropModel(name = "Peacock"),
                    DropModel(name = "Owl"),
                    DropModel(name = "Parrot"),
                    DropModel(name = "Swan"),
                    DropModel(name = "Penguin"),
                )
            }
            "Body Parts" -> {
                emptyList<DragModel>() to emptyList<DropModel>()
            }
            else -> {
                emptyList<DragModel>() to emptyList<DropModel>()
            }
        }
        dragAdapter.addItem(dragList)
        dropAdapter.addItem(dropList)
    }


    override fun isListEmpty(visibility: Boolean) {
        if (visibility) binding.tvDragDrop.visibility = View.GONE
        else binding.tvDragDrop.visibility = View.VISIBLE

    }

}