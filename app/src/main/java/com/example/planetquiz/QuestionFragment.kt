package com.example.planetquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.planetquiz.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listener for "What is the largest planet?"
        binding.buttonLargestPlanet.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("questionId", 1) // ID for "largest planet"
            findNavController().navigate(
                R.id.action_questionFragment_to_answerFragment,
                bundle
            )
        }

        // Set up click listener for "Which planet has the most moons?"
        binding.buttonMostMoons.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("questionId", 2) // ID for "most moons"
            findNavController().navigate(
                R.id.action_questionFragment_to_answerFragment,
                bundle
            )
        }

        // Set up click listener for "Which planet spins on its side?"
        binding.buttonSpinsSide.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("questionId", 3) // ID for "spins on its side"
            findNavController().navigate(
                R.id.action_questionFragment_to_answerFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}