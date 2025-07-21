package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id(message = "Id is required")//id primary key olarak kullanilir
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*id otomatik olarak artirilir
        ✅ @GeneratedValue(strategy = GenerationType.AUTO)
        Bu anotasyon, id alanının değerinin otomatik olarak oluşturulacağını belirtir.

        AUTO → JPA’ya otomatik strateji seçme şansı verir (yani veritabanına göre uygun bir yöntem seçilir).
        Diğer Stratejiler:
        Strateji	Açıklama
        AUTO	    JPA hangi veritabanını kullandığını tespit edip uygun şekilde otomatik id üretir.
        IDENTITY	Genellikle MySQL gibi veritabanlarında AUTO_INCREMENT davranışı sağlar.
        SEQUENCE	PostgreSQL gibi veritabanlarında kullanılır; bir sequence nesnesi oluşturur.
        TABLE	    ID üretimi için ayrı bir tablo kullanır (pek önerilmez).*/
   

    @unique(message = "Email is required")//email unique olarak kullanilir
    private String email;

    @notnull(message = "Name is required")//name not null olarak kullanilir
    private String name;
    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} 