package com.example.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scoreCardScreen(scoreViewModel: ScoreViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    )
    {

        TopAppBar(title = { Text(text="Basketball Match") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray
            )
        )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Team A",
                    fontSize = 40.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "${scoreViewModel.teamA.value.score}",
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))


                Text(text = "SCORE")

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamA.value = scoreViewModel.teamA.value.copy(
                        score = scoreViewModel.teamA.value.score + 1
                    )
                    //Log.e("ASD", teamA.value.score.toString())
                }) {
                    Text(text = "+1")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamA.value = scoreViewModel.teamA.value.copy(
                        score = scoreViewModel.teamA.value.score + 2
                    )
                })
                {
                    Text(text = "+2")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamA.value = scoreViewModel.teamA.value.copy(
                        score = scoreViewModel.teamA.value.score + 3
                    )
                }) {
                    Text(text = "+3")
                }


            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Divider(
                    color= Color.Black,
                    modifier= Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                )

            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Team B",
                    fontSize = 40.sp)
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "${scoreViewModel.teamB.value.score}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))


                Text(text = "SCORE")

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamB.value = scoreViewModel.teamB.value.copy(
                        score = scoreViewModel.teamB.value.score + 1
                    )
                }) {
                    Text(text = "+1")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamB.value = scoreViewModel.teamB.value.copy(
                        score = scoreViewModel.teamB.value.score + 2
                    )
                }) {
                    Text(text = "+2")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    scoreViewModel.teamB.value = scoreViewModel.teamB.value.copy(
                        score = scoreViewModel.teamB.value.score + 3
                    )
                }) {
                    Text(text = "+3")
                }

            }


        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(onClick = { scoreViewModel.show.value = scoreViewModel.show.value.copy(flag=1) }) {
                    Text(text = "Result")
                }

                Spacer(modifier = Modifier.height(30.dp))

                if (scoreViewModel.show.value.flag == 1) {
                    if ((scoreViewModel.teamA.value.score) > (scoreViewModel.teamB.value.score)) {
                        scoreViewModel.result.value.text = "Winner is Team A"

                    }
                    else if((scoreViewModel.teamA.value.score)==(scoreViewModel.teamB.value.score)){
                        scoreViewModel.result.value = scoreViewModel.result.value.copy(text="It's a draw")
                    }
                    else {
                        scoreViewModel.result.value = scoreViewModel.result.value.copy(text="Winner is Team B")

                    }

                    Text(text = scoreViewModel.result.value.text)
                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = {
                        scoreViewModel.teamA.value = scoreViewModel.teamA.value.copy(score = 0)
                        scoreViewModel.teamB.value = scoreViewModel.teamB.value.copy(score = 0)
                        scoreViewModel.show.value = scoreViewModel.show.value.copy(flag = 0)
                        scoreViewModel.result.value = scoreViewModel.result.value.copy(text = "")

                    })
                    {
                        Text(text = "Reset")
                    }
                }
            }
        }
    }
}