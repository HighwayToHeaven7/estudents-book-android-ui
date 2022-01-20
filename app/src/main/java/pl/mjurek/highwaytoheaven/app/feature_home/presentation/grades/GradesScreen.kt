package pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun GradesScreen(grades: List<SubjectDto>, modifier: Modifier = Modifier) {
    val collapsedState = remember(grades) { grades.map { true }.toMutableStateList() }

    LazyColumn(modifier) {
        grades.forEachIndexed { i, dataItem ->
            stickyHeader {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.size(15.dp))
                    Text(
                        "Przedmiot", //subjectName
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        "Grupa", //subjectName
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        "Semestr", //subjectName
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        "Przewidywana ocena", //subjectName
                        fontWeight = FontWeight.Light,

                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                }
            }

            val collapsed = collapsedState[i]
            item(key = "header_$i") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            collapsedState[i] = !collapsed
                        }
                ) {
                    Icon(
                        Icons.Default.run {
                            if (collapsed)
                                KeyboardArrowDown
                            else
                                KeyboardArrowUp
                        },
                        contentDescription = "",
                        tint = Color.LightGray,
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                    Text(
                        dataItem.subject, //subjectName
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        dataItem.semester,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        dataItem.semester,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                    Text(
                        dataItem.expectedGrade,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                }
                Divider()
            }
            if (!collapsed) {
                items(dataItem.rows) { row ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.size(30.dp))
                        Text(
                            row.grade,
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 10.dp)
                        )
//                        Spacer(modifier = Modifier.size(60.dp))
                        Text(
                            row.weight,
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 10.dp)
                        )
//                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            row.description,
                            modifier = Modifier
                                .padding(vertical = 10.dp, horizontal = 10.dp)
                        )
                    }
                    Divider()
                }
            }
        }
    }
}

