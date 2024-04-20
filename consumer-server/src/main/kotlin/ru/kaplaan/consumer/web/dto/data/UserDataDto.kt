package ru.kaplaan.consumer.web.dto.data

import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.Length
import ru.kaplaan.consumer.web.validation.OnCreate
import ru.kaplaan.consumer.web.validation.OnUpdate
import java.time.LocalDate

data class UserDataDto(
    @field:Min(0, message = "Id пользователя не должен быть меньше 0!", groups = [OnCreate::class, OnUpdate::class])
    var userId: Long,

    @field:NotBlank(message = "Имя не должно быть пустым!", groups = [OnCreate::class, OnUpdate::class])
    val firstname: String,

    @field:NotBlank(message = "Фамилия не должна быть пуста!", groups = [OnCreate::class, OnUpdate::class])
    val surname: String,

    val dateOfBirth: LocalDate,

    @field:Length(min = 12, max = 12, message = "Номер телефон должен состоять из 12 символов!", groups = [OnCreate::class, OnUpdate::class])
    val phoneNumber: String,

    @field:Email(message = "Почта пользователя должна подходить под паттерн почты!", groups = [OnCreate::class, OnUpdate::class])
    val email: String,

    @field:NotBlank(message = "Должность не должна быть пустой!", groups = [OnCreate::class, OnUpdate::class])
    val position: String,

    val salary: UInt,
    val readyToMove: Boolean,
    val readyForBusinessTrips: Boolean
)