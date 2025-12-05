package com.techsavvy.exampleday2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.techsavvy.exampleday2.navigation.NavHostMap
import com.techsavvy.exampleday2.ui.theme.ExampleDay2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() //Hide Status bar & Navigation Bar
        setContent {
            //
            ExampleDay2Theme {
                //Linear Layout, Constraint Layout
                //Column, Row
                //Vertical => Column , Alignment Horizontal , Arrangement Vertical
                //Horizontal => Row , Alignment Vertical , Arrangement Horizontal

              /*  Column(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    //horizontally all layout be in centre
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween

                )
                {
                    CustomText("Shakil")
                    CustomText("Salman")
                    CustomText("SHkal")
                    //Row
                    Row(
                        modifier = Modifier
                            .background(Color.Yellow)
//                            .fillMaxWidth()
                            .padding(
//                                horizontal = 10.dp,
//                                vertical = 10.dp
                            )
                            .padding(
//                                all = 20.dp
                            )
                            .padding(
                                start = 15.dp,
                                top=30.dp,
                                end=20.dp,
                                bottom=50.dp
                            )

                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround

                    ) {
                        CustomButton("Login", onClick = {
                            //event received
                            //Login functionality
                        })
                        Spacer(
                            modifier = Modifier.width(20.dp)
                        )
                        CustomButton("Signup",onClick = {
                            //event received
                            //Signup functionality
                        })
                    }
                }*/

                /*Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    TechSavvyCard()

                }*/

                NavHostMap()

            }
        }
    }

    override fun onStart() {
        super.onStart()

    }

}

fun add(a: Int, b: Int): Int {
    return a + b
}

@Composable
fun CustomText(str : String){
    //Text Composable
    Text(
        text = "Welcome " + str,
        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .fillMaxSize()
            .background(Color.Green),
        fontSize = 48.sp,
        fontFamily = FontFamily.Serif
    )
}

fun onClick(){

}

@Composable
fun TechSavvyCard(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1E3FAE),
                        Color(0xFF783AE9)
                    )
                )
            )
    ) {

        Text(
            text = "Tech Savvy Solution",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top=15.dp, start = 10.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(60.dp)
        )

        //Icon
        //Image
//        Icon(
//            painter = painterResource(R.drawable.ic_launcher_foreground),
//            ""
//        )
//        Icon(
//            imageVector = Icons.Default.Person,
//            "",
//            modifier = Modifier.height(60.dp)
//                .width(60.dp)
//                .align(
//                    Alignment.CenterHorizontally
//                )
//        )
        AsyncImage(
            model = "https://tech-savvy-solution.web.app/assets/logo_gr_tr.png",
            "",
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_background),
            onError = {
                Log.d("ERROR",it.result.throwable.message.toString())
            },
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .align(
                    Alignment.CenterHorizontally
                )
                .clip(CircleShape)
                .background(Color.Black)


        )

        Spacer(
            Modifier.height(30.dp)
        )

        Text(
            text = "Empowering Students",
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(bottom = 5.dp),
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "with Real-World Tech Skills",
            fontSize = 22.sp,
            color = Color(0xFFEDEAF9),
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(bottom = 10.dp),
        )

        Card(
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(bottom = 44.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF8561E3)
            ),
//            shape = RoundedCornerShape(
//                topStart = 10.dp,
//                bottomEnd = 10.dp
//            )
            shape = CircleShape
//            shape = RectangleShape
        ) {
            Text("🏫 MSME Registered",
                fontSize=14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .padding(
                        horizontal = 10.dp
                    )
                )
        }




    }
}

@Composable
fun CustomButton(buttonName : String, onClick: () -> Unit){
    Button(onClick = onClick) {
        Text(text = buttonName)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExampleDay2Theme {
        Greeting("Android")
    }
}