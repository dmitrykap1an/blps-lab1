package ru.kaplaan.api.web.dto.consumerServer.data

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length
import ru.kaplaan.api.web.validation.OnCreate
import ru.kaplaan.api.web.validation.OnUpdate
import java.time.LocalDate

@Schema(description = "Сущность информации о пользователе")
data class UserDataDto(
    @Schema(description = "Имя пользователя", example = "Иван")
    @field:NotBlank(message = "Имя пользователя должно быть заполнено!", groups = [OnCreate::class, OnUpdate::class])
    val firstname: String,

    @Schema(description = "Фамилия пользователя", example = "Иванов")
    @field:NotBlank(message = "Фамилия не должна быть пуста!", groups = [OnCreate::class, OnUpdate::class])
    val surname: String,

    @Schema(description = "Дата рождения пользователя", example = "1998-03-01")
    val dateOfBirth: LocalDate,

    @Schema(description = "Номер телефона пользователя", example = "+79529999999")
    @field:Length(min = 12, max = 12, message = "Номер телефон должен состоять из 12 символов!", groups = [OnCreate::class, OnUpdate::class])
    val phoneNumber: String,

    @Schema(description = "Почта пользователя", example = "account@yandex.ru")
    @field:Email(message = "Почта пользователя должна подходить под паттерн почты!", groups = [OnCreate::class, OnUpdate::class])
    val email: String,

    @Schema(description = "Позиция в компании, которую хочет получить пользователь", example = "CEO")
    @field:NotBlank(message = "Должность не должна быть пустой!", groups = [OnCreate::class, OnUpdate::class])
    val position: String,

    @Schema(description = "Ожидаемая зарплата", example = "100 000")
    val salary: UInt,

    @Schema(description = "Готовность к переезду", example = "true")
    val readyToMove: Boolean,

    @Schema(description = "Готовность к командировкам", example = "true")
    val readyForBusinessTrips: Boolean
){
    @Schema(description = "Id пользователя", hidden = true)
    @field:Null(message = "Id пользователя не должен быть заполнен!", groups = [OnCreate::class, OnUpdate::class])
    var userId: Long? = null
}