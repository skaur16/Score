package com.example.score

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.score.models.Team

class ScoreViewModel : ViewModel() {

    val teamA = mutableStateOf(Team())
    val teamB = mutableStateOf(Team())
    val show  = mutableStateOf(Team())
    val result = mutableStateOf(Team())
}