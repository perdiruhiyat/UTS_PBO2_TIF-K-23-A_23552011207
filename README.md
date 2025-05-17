# UTS_PBO2_TIF-K-23-A_23552011207
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Perdi Ruhiyat</li>
  <li>NIM: 23552011207</li>
  <li>Studi Kasus: To-Do List</li>
</ul>


## Judul Studi Kasus
<p>To-Do List dengan Menggunakan Java Spring Boot dan Thymeleaf</p>

## Penjelasan Studi Kasus
<p>
Di studi kasus ini, saya membuat aplikasi To-Do List berbasis web. Jadi user bisa daftar akun atau registrasi, login, dan mulai menambahkan todo nya. Fitur utamanya termasuk tambah tugas, edit, hapus, dan lihat daftar tugas yang sudah dibuat.
</p>
<p>
Lalu, pada studi kasus ini saya menggunakan Spring Boot sebagai backend utama, Thymeleaf buat templating, MySQL untuk penyimpanan data, dan Bootstrap untuk membuat tampilan lebih rapi dan responsif. Aplikasi ini juga udah dilengkapi fitur login dan logout pakai Spring Security, jadi data antar pengguna tidak bisa saling diakses.
</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>
Konsep ini saya terapkan saat membuat class <code>UserService</code> yang <i>mengimplementasikan</i> interface <code>UserDetailsService</code> dari Spring Security. Artinya, class <code>UserService</code> “mewarisi” aturan dari interface itu, dan harus mengisi method <code>loadUserByUsername()</code>. Ini yang dipakai Spring buat proses autentikasi user saat login.
</p>

### 2. Encapsulation
<p>
Untuk Encapsulation yang diguanakan di studi kasus saya berada di class <code>User</code> dan <code>ToDo</code>, semua atribut diset private seperti <code>username</code>, <code>password</code>, dan <code>task</code>. Untuk mengaksesnya, hanya dapat menggunakan getter dan setter. Ini supaya data lebih aman dan nggak bisa diubah sembarangan dari luar.
</p>

### 3. Polymorphism
<p>
Polymorphism muncul saat dsys pakai interface <code>UserDetailsService</code>. Class <code>UserService</code> bisa diperlakukan sebagai tipe <code>UserDetailsService</code> meskipun isinya beda. Jadi, kode jadi lebih fleksibel dan gampang di-maintain. Contoh lainnya, Spring Security juga bisa langsung pake <code>UserService</code> tanpa perlu tau detailnya.
</p>

### 4. Abstraction
<p>
Abstraksi terlihat jelas saat menggunakan interface seperti <code>JpaRepository</code> dari Spring Data JPA. Kita hanya tidak pakai method-method seperti <code>findByUsername()</code> atau <code>save()</code>, tanpa harus memikirkan logika SQL-nya gimana. Dan ini membantu sekali untuk fokus ke logika aplikasi, bukan detail teknis di belakangnya.
</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/perdiruhiyat/UTS_PBO2_TIF-K-23-A_23552011207.git">Github</a></li>
  <li>Google Drive: <a href="https://drive.google.com/file/d/1_RbH6S8oxQihSRTE5j2ETqV43hT9pg_H/view?usp=sharing">Google Drive</a></li>
</ul>
