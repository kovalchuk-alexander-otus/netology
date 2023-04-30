package ru.maki.client;

public class Mail implements Contact{
    private String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    @Override
    public String getInfo() {
        return this.mail;
    }

    public void sendMessage(String message){
        System.out.println("\n..отправлено сообщение Клиенту");
        System.out.println(message);
    }
}
