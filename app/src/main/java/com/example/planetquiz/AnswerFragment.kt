package com.example.planetquiz // Replace with your package name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planetquiz.databinding.FragmentAnswerBinding

class AnswerFragment : Fragment() {

    private var _binding: FragmentAnswerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnswerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionId = arguments?.getInt("questionId") ?: 0

        val questionText: String
        val correctAnswerId: Int
        val explanationText: String

        when (questionId) {
            1 -> {
                questionText = "What is the largest planet?"
                correctAnswerId = R.id.radio_jupiter
                explanationText = "Jupiter is the largest planet and is 2.5 times the mass of all the other planets put together."
            }
            2 -> {
                questionText = "Which planet has the most moons?"
                correctAnswerId = R.id.radio_saturn
                explanationText = "Saturn has the most moons and has 82 moons."
            }
            3 -> {
                questionText = "Which planet spins on its side?"
                correctAnswerId = R.id.radio_uranus
                explanationText = "Uranus spins on its side with its axis at nearly a right angle to the Sun."
            }
            else -> {
                questionText = "Invalid question."
                correctAnswerId = -1
                explanationText = ""
            }
        }

        binding.textViewQuestion.text = questionText

        binding.buttonSubmit.setOnClickListener {
            val selectedId = binding.radioGroupPlanets.checkedRadioButtonId
            if (selectedId != -1) {
                if (selectedId == correctAnswerId) {
                    binding.textViewResult.text = "Correct! ✅"
                } else {
                    binding.textViewResult.text = "Wrong! ❌"
                }

                binding.textViewExplanation.text = explanationText
                binding.textViewResult.visibility = View.VISIBLE
                binding.textViewExplanation.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}