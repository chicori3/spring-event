package toy.sian.spring.event.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
    id: Long = 0,
    name: String,
    price: Long,
    quantity: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(name = "name", nullable = false)
    var name = name
        protected set

    @Column(name = "price", nullable = false)
    var price = price
        protected set

    @Column(name = "quantity", nullable = false)
    var quantity = quantity
        protected set
}