package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController/*@RestController	Bu sınıf bir REST API controller'ıdır. Geriye JSON döner.
Listeleme (GET)

Oluşturma (POST)

Tek bir kullanıcıyı getirme (GET /id)

Güncelleme (PUT)

Silme (DELETE) */
@RequestMapping("/users")/*@RequestMapping("/users")	Bu controller tüm yolları /users ile başlatır */
public class UserController {//UserController kullaniciyi kontrol etmek icin kullanilir

    @Autowired//@Autowired	Spring bu satırda UserRepository'yi otomatik olarak sağlar (bağımlılık enjeksiyonu).
    private UserRepository userRepository;

    @GetMapping//get kullaniciyi getirir        
    public List<User> getAllUsers() {
        return userRepository.findAll();//findAll kullaniciyi getirir 	GET /users
    }

    @PostMapping//post kullaniciyi olusturmak icin kullanilir
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);//save kullaniciyi olusturur   POST /users   
    }
    //asagisi yeni ekledigimiz kodlar

    @GetMapping("/{id}")//get kullaniciyi getirir
    /* @PathVariable → URL'deki {id} kısmını alır
      ResponseEntity → Hem veri hem HTTP durumu döner*/
    public ResponseEntity<User> getUserById(@PathVariable Long id) { 
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")//put kullaniciyi guncellemek icin kullanilir
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());//name kullaniciyi guncellemek icin kullanilir
                    user.setEmail(userDetails.getEmail());//email kullaniciyi guncellemek icin kullanilir
                    User updatedUser = userRepository.save(user);//save kullaniciyi guncellemek icin kullanilir
                    return ResponseEntity.ok(updatedUser);//"Güncellenmiş kullanıcıyı (JSON olarak) döndür ve HTTP durum kodu olarak 200 OK gönder."
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")//delete kullaniciyi silmek icin kullanilir      
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);//delete kullaniciyi silmek icin kullanilir
                    return ResponseEntity.noContent().build();//noContent kullaniciyi silmek icin kullanilir
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 