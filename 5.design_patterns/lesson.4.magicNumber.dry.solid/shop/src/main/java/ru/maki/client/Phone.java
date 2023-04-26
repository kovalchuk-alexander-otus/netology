package ru.maki.client;

public class Phone implements Contact{
    private String phone;
    @Override
    public String getInfo() {
        return this.phone;
    }

    public void makeCall(String message){
        System.out.println("\n..выполнен звонок Клиенту");
        System.out.println(message);
    }
}
