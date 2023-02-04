package pojos;

public class POJOJsonPlaceHolder {
    /*
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    // 1. adım : objemizin içerisinde var olan tüm key değerlerini private variable olarak tanımlayalım
            // adı key'l aynı olmalı
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2. adım getter ve setter  hazırla

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3. adım: tüm parametreleri içeren bir constroctor oluştur


    public POJOJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4. adım: defoult cons. öldüğü için parametresiz constructor oluştur


    public POJOJsonPlaceHolder() {
    }

    // 5. adım: toString() metodu oluştur


    @Override
    public String toString() {
        return "POJOJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
