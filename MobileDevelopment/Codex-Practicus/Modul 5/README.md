# Treble Winner List API

Aplikasi ini dibuat menggunakan [FastAPI](https://fastapi.tiangolo.com/), sebuah framework modern dan cepat untuk membangun API dengan Python 3. Tujuan dari aplikasi ini adalah menyediakan informasi lengkap tentang **klub sepak bola peraih treble continental** (juara liga domestik, piala domestik, dan Liga Champions/kontinental dalam satu musim), yang selama ini sulit ditemukan bahkan tidak tersedia di API sepak bola publik.

Mayoritas API hanya menyajikan data klub-klub Eropa atau terbatas pada kompetisi besar. Dengan adanya API ini, Anda dapat mengakses data treble winner secara khusus, lengkap, dan dapat diatur sesuai kebutuhan Anda.

---

## 📦 Fitur

- Menyediakan data klub treble winner dari berbagai benua
- Struktur modular menggunakan FastAPI dan Python typing
- Data dapat digunakan oleh aplikasi klien (misal: Android)
- Dukungan CORS untuk akses dari perangkat tertentu
- Customisable dan mudah dikembangkan

---

## ⚙️ Instalasi

Pastikan Anda menggunakan Python 3.9+ dan sudah membuat virtual environment:

```bash
pip install fastapi uvicorn

```

## Menjalankan API
1. Aktifkan virtual environment python
```bash
source .venv/Scripts/activate  # Windows
# atau
source .venv/bin/activate      # Linux/macOS
```
2. Edit file `Football API/main.py`
Ubah konfigurasi CORS agar bisa diakses dari perangkat Anda.
Pada `main.py` (sekitar baris 41), ubah:
`allow_origins=[]`
Menjadi:
`allow_origins=["http://<IP-ADDRESS-ANDA>:<PORT>"]`
Ganti `<IP-ADDRESS-ANDA>` sesuai alamat IP host Anda (cek dengan `ipconfig` di Windows atau `ifconfig/ip addr` di Linux/Mac).
3. Jalankan server Fast API
```bash
uvicorn main:app --reload --host 0.0.0.0 --port 8000
```
4. Konfigurasi Windows Firewall untuk mengizinkan koneksi ke port 8000:

Jika API tidak bisa diakses dari perangkat lain, kemungkinan firewall Windows memblokir port 8000. Ikuti langkah berikut:

- Buka Windows Defender Firewall dengan mengetik "Firewall" pada menu Start dan pilih Windows Defender Firewall with Advanced Security.

- Pilih menu Inbound Rules di panel kiri.

- Klik New Rule... di panel kanan.

- Pilih Port, lalu klik Next.

- Pilih TCP dan masukkan port yang digunakan, misalnya 8000, lalu klik Next.

- Pilih Allow the connection, klik Next.

- Pastikan semua profil (Domain, Private, Public) dicentang sesuai kebutuhan, klik Next.

- Beri nama rule ini, misalnya FastAPI Port 8000, klik Finish.

5. Cek kembali koneksi dengan perangkat lain dalam jaringan menggunakan browser atau aplikasi client.

6. Ubah `BASE_URL` di file `root/data/remote/di/NetworkModule.kt` menjadi IP yang sama dengan yang dikonfigurasi untuk Fast API.