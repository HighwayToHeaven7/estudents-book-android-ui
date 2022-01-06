package pl.mjurek.highwaytoheaven.app.feature_home.presentation.user_data

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceLarge
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceMedium
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.StudentDetailDto

@Composable
fun UserDataScreen(
    student: StudentDetailDto = StudentDetailDto(
        nameAndSurname = "Jan, Jacek Stępień",
        familyName = "-",
        studentsAlbumNumber = "D/123321",
        sex = "Mężczyzna",
        province = "Małopolskie",
        personalIdfentityNumber = "48081375648",
        dateOfBith = "20-10-1995",
        placeOfBith = "Kraków",
        residence = "Lenartowicza Teofila 13 Krakow, Poland"
    )
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(20.dp),
    ) {
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
            value = student.personalIdfentityNumber
        )
        RowWithData(
            nameLabel = stringResource(id = R.string.date_of_birth),
            value = student.dateOfBith
        )
        RowWithData(
            nameLabel = stringResource(id = R.string.place_of_birth),
            value = student.placeOfBith
        )
    }
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
    Spacer(modifier = Modifier.height(space))
}

@Preview
@Composable
fun UserDataScreenPreview() {
    UserDataScreen()
}