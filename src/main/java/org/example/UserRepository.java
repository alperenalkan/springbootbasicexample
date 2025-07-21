package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository/*@Repository
Bu anotasyon, bu arayüzün bir veritabanı bileşeni (DAO) olduğunu belirtir.JpaRepository, CrudRepository gibi arayüzlerden extend edilir.
DAO:Veritabanıyla doğrudan iletişim kuran sınıftır. Spring Boot’ta DAO = @Repository

SQL veya ORM (JPA/Hibernate gibi) aracılığıyla:

veri ekleme (insert),

veri okuma (select),

veri güncelleme (update),

veri silme (delete)   işlemlerini yapar.

Uygulamanın geri kalan kısmını veritabanı detaylarından bağımsız tutar.

Spring bu sayede:

Arayüzü bulur (component scanning).

Otomatik olarak bir bean üretir.

İçindeki metodları try-catch ile sarar, veritabanı hatalarını düzgün yönetir.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    //UserRepository kullaniciyi kontrol etmek icin kullanilir

    /* 🔍 Peki bu arayüze özel metotlar ekleyebilir misin?
        Evet, ekleyebilirsin. Spring Data JPA, metot isimlerinden otomatik sorgu üretir:

        findByName(String name) → SELECT * FROM users WHERE name = ?

        findByEmail(String email) → SELECT * FROM users WHERE email = ?

   */
    List<User> findByName(String name);//name kullaniciyi getirir
    Optional<User> findByEmail(String email);//email kullaniciyi getirir

} 