package org.example.controller;import lombok.Getter;import lombok.Setter;import org.example.entity.Profile;import org.example.service.CardService;import org.example.service.impl.CardServiceImpl;import org.example.util.Utils;@Getter@Setterpublic class CardController {    private final CardService cardService;    public CardController() {        this.cardService = new CardServiceImpl();    }    public void manage(Profile profile) {        System.out.println("1. Create Card(number,exp_date)\n" +                "    2. Card List\n" +                "    3. Update Card (number,exp_date)\n" +                "    4. Change Card status\n" +                "    5. Delete Card\n" +                "    0. Exit");        int menu = Utils.getIntScanner();        String phone;        switch (menu) {            case 1 -> {                createCard(Utils.getCardNumber(), Utils.getExpDate());            }            case 2 -> {                cardList();            }            case 3 -> {                System.out.print("Phone >> ");                phone = Utils.getStringScanner();                updateCard(phone);            }            case 4 -> {                System.out.print("Phone >> ");                phone = Utils.getStringScanner();                changeCardStatus(phone);            }            case 5 -> {                System.out.print("Phone >> ");                phone = Utils.getStringScanner();                deleteCard(phone);            }            case 0 -> {                return;            }            default -> {                System.out.println("Try again!");            }        }        manage(profile);    }    public void createCard(String number, String expDate) {        cardService.addCard(number, expDate);    }    private void deleteCard(String phone) {        cardService.deleteCard(phone);    }    private void changeCardStatus(String cardNumber) {        cardService.changeCardStatus(cardNumber);    }    private void updateCard(String cardNumber) {        cardService.updateCard(cardNumber);    }    private void cardList() {        cardService.cardList();    }    public void transactionList() {        cardService.transactionList();    }    public void statistics(Profile profile) {        cardService.statistics(profile);    }}