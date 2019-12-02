package Database;

import Model.Stock;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Database {

//    private static final String namePath = "/Users/agarw9646/IdeaProjects/CompSciIA/src/Database/names";
//    private static final String emailPath = "/Users/agarw9646/IdeaProjects/CompSciIA/src/Database/emails";
//    private static final String passPath = "/Users/agarw9646/IdeaProjects/CompSciIA/src/Database/passwords";
//    private static final String stockPath = "/Users/agarw9646/IdeaProjects/CompSciIA/src/Database/stocks";
//    private static final String cashPath = "/Users/agarw9646/IdeaProjects/CompSciIA/src/Database/cash";

    private static final String namePath = "/Users/Krish/IdeaProjects/CompSciIA/src/Database/names";
    private static final String emailPath = "/Users/Krish/IdeaProjects/CompSciIA/src/Database/emails";
    private static final String passPath = "/Users/Krish/IdeaProjects/CompSciIA/src/Database/passwords";
    private static final String stockPath = "/Users/Krish/IdeaProjects/CompSciIA/src/Database/stocks";
    private static final String cashPath = "/Users/Krish/IdeaProjects/CompSciIA/src/Database/cash";

    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> emails = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();
    private static ArrayList<String> stocks = new ArrayList<>();
    private static ArrayList<String> cash = new ArrayList<>();

    public static String getName(int index) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(namePath));
        while (scanner.hasNext()) {
            names.add(scanner.nextLine());
        }
        return names.get(index);
    }

    public static ArrayList<String> getEmails() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(emailPath));
        while (scanner.hasNext()) {
            emails.add(scanner.nextLine());
        }
        return emails;
    }

    public static String getEmail(int index) throws FileNotFoundException {
        return getEmails().get(index);
    }

    public static ArrayList<String> getPasswords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(passPath));
        while (scanner.hasNext()) {
            passwords.add(scanner.nextLine());
        }
        return passwords;
    }

    public static String getPassword(int index) throws FileNotFoundException {
        return getPasswords().get(index);
    }

    public static int[] getStocks(int index) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(stockPath));
        while (scanner.hasNext()) {
            stocks.add(scanner.nextLine());
        }
        return Arrays.stream(stocks.get(index).split("\\s")).mapToInt(Integer::parseInt).toArray();
    }

    public static double[] getValues(int index) throws FileNotFoundException {
        int[] quantities = getStocks(index);
        double[] values = new double[6];
        for (int i = 0; i < 6; i++) {
            values[i] = quantities[i] * Stock.getPrices()[i];
        }
        return values;
    }

    public static double getCash(int index) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(cashPath));
        while (scanner.hasNext()) {
            cash.add(scanner.nextLine());
        }
        return Double.parseDouble(cash.get(index));
    }

    public static void addName(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(namePath, true));
        writer.append("\n").append(name);
        writer.close();
    }

    public static void addEmail(String email) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(emailPath, true));
        writer.append("\n").append(email);
        writer.close();
    }

    public static void addPassword(String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(passPath, true));
        writer.append("\n").append(password);
        writer.close();
    }

    public static void fillInfo() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(stockPath, true));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(cashPath, true));
        writer.append("\n").append("0 0 0 0 0 0");
        writer2.append("\n").append("0");
        writer.close();
        writer2.close();
    }

    public static void changeLine(String path, String newLine, int index) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        ArrayList<String> newLines = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            newLines.add(lines.get(i));
        }
        newLines.add(newLine);
        for (int i = index + 1; i < lines.size(); i++) {
            newLines.add(lines.get(i));
        }
        Path file = Paths.get(path);
        Files.write(file, newLines, StandardCharsets.UTF_8);
    }

    public static String getStockPath() {
        return stockPath;
    }
}
