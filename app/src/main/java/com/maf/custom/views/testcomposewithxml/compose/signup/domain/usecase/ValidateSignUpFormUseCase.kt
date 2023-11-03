package com.maf.custom.views.testcomposewithxml.compose.signup.domain.usecase

import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpErrorState
import javax.inject.Inject

class ValidateSignUpFormUseCase @Inject constructor() {

    operator fun invoke(
        fullName: String,
        email: String,
        password: String
    ): SignUpErrorState {
        val fullNameRegex = Regex("[a-zA-Z\\s]+")
        val emailRegex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")

        if (fullName.isBlank() || !fullName.matches(fullNameRegex)) {
            return SignUpErrorState.FullName
        }

        if (email.isBlank() || !email.matches(emailRegex)) {
            return SignUpErrorState.Email
        }

        if (password.isBlank()) {
            return SignUpErrorState.Password
        }

        return SignUpErrorState.None
    }
}