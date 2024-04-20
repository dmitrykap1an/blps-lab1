package ru.kaplaan.consumer.domain.entity.vacancyResponse

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table

@Table("vacancy_response")
class VacancyResponse{

    @Id
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    lateinit var pk: PK

    data class PK(
        @Column("vacancy_id")
        val vacancyId: Long,
        @Column("user_id")
        val userId: Long
    )
}