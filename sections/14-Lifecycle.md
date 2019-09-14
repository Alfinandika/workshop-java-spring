# Lifecycle

Kadang saat kita membuat sebuah bean, biasanya ada yang perlu kita lakukan pada tahap awal dan tahap akhir. ketika pertama dibuat perlu melakukan hal apa, dan saat distop perlu melakukan hal apa

Contohnya adalah kita buat class yang mana class tersebut untuk connect ke database

File Service/DatabaseService.java
```java
@Component
public class DatabaseService {

    @PostConstruct
    public void openConnection(){
        System.out.println("MEMBUKA KONEKSI KE DATABASE");
    }

    @PreDestroy
    public void closeConnection(){
        System.out.println("MENUTUP KONEKSI KE DATABASE");
    }
}
```
method dengan anotasi @PostConstruct akan dijalankan ketia Bean dengan tipe class DatabaseService selesai dibuat dan setelah semua dependency injection nya selesai dimasukan.

method dengan anotasi @PreDestroy akan dijalankan ketia Bean dengan tipe class DatabaseService dishutdown.


kita coba menggunakan anotasi @PostConstruct dan @PreDestroy pada DataBean

```java
    @PostConstruct
    public void init(){
        System.out.println("init databean = "+value);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy databean = "+value);
    }
```

Yang perlu kita ketahui, ketika Scopenya adalah prototype tanggung jawab spring hanya sampai pada pembuatan object, setelah itu tanggung jawabnya di serahkan ke yang memanggil. jadi spring tidak akan mengeksekusi @PreDestroy pada Bean dengan scope prototype