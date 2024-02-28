package com.herokuapp.uitests;

import com.herokuapp.uitests.CustomException;

import java.util.Scanner;

public class UserLoginProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ім'я користувача:");
        String username = scanner.nextLine();

        System.out.println("Введіть пароль:");
        String password = scanner.nextLine();

        try {
            validateInput(username, password);
            System.out.println("Вхід в систему успішно виконаний");
        } catch (CustomException e) {
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void validateInput(String username, String password) throws CustomException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new CustomException("Ім'я користувача або пароль не можуть бути порожніми або NULL");
        }

        if (password.length() < 6) {
            throw new CustomException("Довжина паролю повинна бути не менше 6 символів");
        }


        // Якщо ім'я та пароль не співпадають з попередньо заданими значеннями
        String expectedUsername = "admin";
        String expectedPassword = "admin123";

        if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
            throw new CustomException("Неправильне ім'я користувача або пароль");
        }
    }
}

