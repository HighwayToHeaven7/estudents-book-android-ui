package pl.mjurek.highwaytoheaven.app.feature_home.presentation.user_data

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceLarge
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceMedium
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.AddressData
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.StudentDetailDto

@Composable
fun UserDataScreen(
    student: StudentDetailDto = StudentDetailDto(
        nameAndSurname = "Jan, Jacek Stępień",
        familyName = "-",
        sex = "Mężczyzna",
        studentsAlbumNumber = "D/123321",
        residence = "Lenartowicza Teofila 13 Krakow, Poland",
        province = "Małopolskie",
        personalIdentityNumber = "48081375648",
        dateOfBirth = "20-10-1995",
        placeOfBirth = "Kraków",
        address = AddressData(
            phoneNumber = "+48 678143876",
            anotherPhoneNumber = "-",
            correspondenceAddress = "Lenartowicza Teofila 13/6 Krakow, Poland",
            email = "example.email@gmail.com"
        )
    ),
    tabs: List<UserInfoTabs> = listOf(
        UserInfoTabs(
            title = "DANE PODSTAWOWE",
            content = { BasicPersonalDataSubScreen(student = student) }

        ),
        UserInfoTabs(
            title = "DANE TELEADRESOWE",
            content = { AddressDataSumScreen(address = student.address) }
        )
    )
) {
    val collapsedState = remember(tabs) { tabs.map { true }.toMutableStateList() }
    HeaderSubScreen()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        tabs.forEachIndexed { i, tabItem ->
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
                        tint = Color.Blue,
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                    Text(
                        text = tabItem.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                }
            }
            if (!collapsed) {
                item {
                    Column(modifier = Modifier.padding(start = 30.dp, end = 30.dp)) {
                        tabItem.content.invoke()
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderSubScreen() {


}

@Composable
fun BasicPersonalDataSubScreen(student: StudentDetailDto) {
    RowWithData(
        nameLabel = stringResource(id = R.string.surname_and_login),
        value = student.nameAndSurname
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.family_name),
        value = student.familyName
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.sex),
        value = student.sex,
        space = SpaceLarge
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.student_album),
        value = student.studentsAlbumNumber,
        space = SpaceLarge
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.residence),
        value = student.residence
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.province),
        value = student.province,
        space = SpaceLarge
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.pesel),
        value = student.personalIdentityNumber
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.date_of_birth),
        value = student.dateOfBirth
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.place_of_birth),
        value = student.placeOfBirth
    )
}

@Composable
fun AddressDataSumScreen(address: AddressData) {
    RowWithData(
        nameLabel = stringResource(id = R.string.telephone),
        value = address.phoneNumber
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.another_telephone),
        value = address.anotherPhoneNumber
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.email),
        value = address.email
    )
    RowWithData(
        nameLabel = stringResource(id = R.string.correspondence_address),
        value = address.correspondenceAddress
    )
}

@Composable
fun RowWithData(nameLabel: String, value: String, space: Dp = SpaceMedium) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = nameLabel,
            modifier = Modifier.width(130.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            modifier = Modifier.offset(30.dp)
        )
    }
    Divider()
    Spacer(modifier = Modifier.height(space))
}

data class UserInfoTabs(
    val title: String,
    val content: @Composable () -> Unit
)

@Preview
@Composable
fun UserDataScreenPreview() {
    UserDataScreen()
}