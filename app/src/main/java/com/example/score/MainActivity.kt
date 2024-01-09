package com.example.score

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.score.models.Team
import com.example.score.ui.theme.ScoreTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val teamA = remember { mutableStateOf(Team()) }
                    val teamB = remember { mutableStateOf(Team()) }
                    val show= remember{mutableStateOf(Team())}
                    val result = remember{mutableStateOf(Team())}

                    

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

                                Text(text = "${teamA.value.score}",
                                    fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(10.dp))


                                Text(text = "SCORE")

                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamA.value = teamA.value.copy(
                                        score = teamA.value.score + 1
                                    )
                                    //Log.e("ASD", teamA.value.score.toString())
                                }) {
                                    Text(text = "+1")
                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamA.value = teamA.value.copy(
                                        score = teamA.value.score + 2
                                    )
                                })
                                    {
                                    Text(text = "+2")
                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamA.value = teamA.value.copy(
                                    score = teamA.value.score + 3
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

                                Text(text = "${teamB.value.score}",
                                    fontSize = 20.sp
                                    )
                                Spacer(modifier = Modifier.height(10.dp))


                                Text(text = "SCORE")

                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamB.value = teamB.value.copy(
                                    score = teamB.value.score + 1
                                )
                                }) {
                                    Text(text = "+1")
                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamB.value = teamB.value.copy(
                                    score = teamB.value.score + 2
                                )
                                }) {
                                    Text(text = "+2")
                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(onClick = {
                                    teamB.value = teamB.value.copy(
                                        score = teamB.value.score + 3
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

                                Button(onClick = { show.value = show.value.copy(flag=1) }) {
                                    Text(text = "Result")
                                }

                                Spacer(modifier = Modifier.height(30.dp))

                                if (show.value.flag == 1) {
                                    if ((teamA.value.score) > (teamB.value.score)) {
                                        result.value.text = "Winner is Team A"

                                    }
                                    else if((teamA.value.score)==(teamB.value.score)){
                                        result.value = result.value.copy(text="It's a draw")
                                    }
                                    else {
                                        result.value = result.value.copy(text="Winner is Team B")

                                    }

                                    Text(text = result.value.text)
                                    Spacer(modifier = Modifier.height(30.dp))

                                    Button(onClick = {
                                        teamA.value=teamA.value.copy(score = 0)
                                        teamB.value=teamB.value.copy(score = 0)
                                        show.value = show.value.copy(flag = 0)
                                        result.value = result.value.copy(text = "")

                                    })
                                    {
                                        Text(text = "Reset")
                                    }
                                }
                            }
                        }
                        }
                        }
                    }
                }
                }
            }




