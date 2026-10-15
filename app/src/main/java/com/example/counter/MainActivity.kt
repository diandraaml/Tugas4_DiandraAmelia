
package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel = viewModel()
) {
    val count = counterViewModel.count

    val nim = "245150401111046"
    val nama = "Diandra Amelia Hartanto"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Nama: $nama", fontSize = 18.sp)
        Text(text = "NIM: $nim", fontSize = 18.sp)


        Spacer(modifier = Modifier.height(36.dp))

        Text(text = "Nilai Counter", fontSize = 18.sp)

        Text(
            text = count.toString(),
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { counterViewModel.up() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Up")
            }

            Button(
                onClick = { counterViewModel.down() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Down")
            }
        }


        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { counterViewModel.reset() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset")
        }
    }
}
