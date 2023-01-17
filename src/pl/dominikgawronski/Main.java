package pl.dominikgawronski;
import java.util.Scanner;

import static java.lang.Math.pow;


public class Main {

    public static void main(String[] args) { // main, czyli wiadomość jaka pojawia się przy uruchamianiu programu, wywołuje od razu Menu
        System.out.println("Dzień dobry, przed Tobą prosty kalkulator.");
        double wynik = 0;
        double pierwsza_liczba = wpiszLiczbe(wynik);
        wynik = pierwsza_liczba;
        Poczatek(wynik); // Wywołanie metody Poczatek, zaraz po starcie programu
    }

    static void Wybor_menu(double numer_menu, double wynik){ // Metoda Wybor_menu, pętla switch case pozwala na wybór możliwości w kalkulatorze z wymienionych metodą Początek
        switch ((int) numer_menu) {
            case 1: // Case 1, dodawanie, wywołuje metodę dodawanie
                System.out.println("Wybrałeś/aś dodawanie.");
                double suma = Dodawanie(wynik, wpiszLiczbe(wynik));
                System.out.println("Suma: " + suma);
                Poczatek(suma);
                break;
            case 2: // Case 2, odejmowanie, wywołuje metodę odejmowanie
                System.out.println("Wybrałeś/aś odejmowanie.");
                double roznica = Odejmowanie(wynik, wpiszLiczbe(wynik));
                System.out.println("Róznica: " + roznica);
                Poczatek(roznica);
            break;
            case 3: // Case 3, mnożenie, wywołuje metodę mnozenie
                System.out.println("Wybrałeś/aś mnożenie.");
                double iloczyn = Mnozenie(wynik, wpiszLiczbe(wynik));
                System.out.println("Iloczyn: " + iloczyn);
                Poczatek(iloczyn);
                break;
            case 4: // Case 4, dzielenie, wywołuje metodę Dzielenie
                System.out.println("Wybrałeś/aś dzielenie.");
                double mianownik = wpiszLiczbe(wynik);
                while (mianownik == 0){ // pętla sprawdzająca czy użytkownik dzieli przez zero
                    System.out.println("Nie można dzielić przez 0. Spróbuj jeszcze raz.");
                    mianownik = wpiszLiczbe(wynik);
                }
                double iloraz = Dzielenie(wynik, mianownik);
                System.out.println("Iloraz: " + iloraz);
                Poczatek(iloraz);
                break;
            case 5: // Case 5, potęgowanie, wywołuje metodę Potegowanie
                System.out.println("Wybrałeś/aś potęgowanie.");
                System.out.println("Do jakiej potęgi chcesz podnieść " + wynik);
                double potega = wpiszLiczbe(wynik);
                double wynikpotegowania = Potegowanie(wynik, potega);
                System.out.println("Liczba " + wynik + " będzie podniesiona do potęgi " + potega);
                System.out.println("Wynik: " + wynikpotegowania);
                Poczatek(wynikpotegowania);
                break;
            case 6: // Case 6, pierwastkowanie do kwadratu, wywoluje metodę PierwiastkowaniaDoKwadratu
                System.out.println("Wybrałeś/aś pierwiastkowanie do kwadratu.");
                double pierwiastek = PierwiastkowaniaDoKwadratu(wynik);
                System.out.println("Pierwaistek drugiego stopnia z " + wynik + " = " + pierwiastek);
                Poczatek(pierwiastek);
                break;
            case 7: // Case 7, procentowanie, wywołuje metodę ProcentzLiczby
                System.out.println("Wybrałeś/aś Procent z liczby.");
                System.out.print(" Wpisz ile procent z liczby " + wynik + " chciałbyś otrzymać. ");
                double procent = ProcentzLiczby(wynik,wpiszLiczbe(wynik));
                System.out.println("Procent z " + wynik + " to " + procent);
                Poczatek(procent);
                break;
            case 8: // Case 8, Wyzerowanie wyniku, wywołuje metodę Zerowanie oraz prosi o wpisanie nowej liczby
                System.out.println("Wyzerowano wynik");
                wynik = Zerowanie();
                System.out.println("Aktualna wawrtość kalkulatora: " + wynik);
                wynik = wpiszLiczbe(wynik);
                Poczatek(wynik);
                break;
            case 9: // Case 9, zamykanie programu
                System.out.println("Program zamknie się.");
                System.exit(0);
            case 11: // Case 11, poczatek czyli menu, a dokładniej możlowości jakie program oferuje
                Poczatek(wynik);
                break;
            case 12: // Case 12, po wyborze 1.1, dodawanie, wywołuje metodę dodawanie tych samych liczb, przeciążenie funkcji
                System.out.println("Wybrałeś/aś dodawanie dwóch tych samych liczb.");
                double suma_dwa = Dodawanie(wynik);
                System.out.println("Suma: " + suma_dwa);
                Poczatek(suma_dwa);
                break;

        }
    }

    static double Poczatek(double wynik) { // Menu, czyli opcje do wyboru
        double menu = 11; // menu = 11, czyli nadanie wartości zmiennej która będzie używana w pętli wielokrotnego wyboru Switch Case
        System.out.println("Możliwości kalkulatora: ");
        System.out.println("1. Dodawanie.");
        System.out.println("1.1 Dodaj tą samą liczbę.");
        System.out.println("2. Odejmowanie.");
        System.out.println("3. Mnozenie.");
        System.out.println("4. Dzielenie.");
        System.out.println("5. Potęgowanie.");
        System.out.println("6. Pierwiastkowanie do kwadratu.");
        System.out.println("7. Procent z liczby.");
        System.out.println("8. Zerowanie.");
        System.out.println("9. Wyjscie.");
        System.out.println("Aktualna wawrtość kalkulatora: " + wynik);
        System.out.print("Wybierz co chcesz zrobić: ");
        Scanner scan = new Scanner(System.in);
        String wybrana_wartosc_z_menu = scan.nextLine();

        if (czyCyfraJestDodatnia(wybrana_wartosc_z_menu, wynik)) { // pierwszy warunek który wyłapuje źle wpisaną liczbę
            double num_menu_double = Double.parseDouble(wybrana_wartosc_z_menu);
            if (num_menu_double == 1.1){ // warunek sprawdzający czy chcemy dodawać tą samą liczbę
                num_menu_double = 12;
            }
            Wybor_menu(num_menu_double, wynik);
        }
        else {
            Error(menu, wynik);
        }
        return(wynik);
    }

    static double Dodawanie(double jeden, double dwa){ // Metoda Dodawanie, dodaje dwie cyfry
        double suma = jeden + dwa;
        return(suma);
    }

    static double Dodawanie(double jeden){ // Metoda Dodawanie, dodaje dwie ale takie same w tym przypadku, przeciążenie funkcji
        double suma = jeden + jeden;
        return(suma);
    }

    static double Odejmowanie(double jeden, double dwa){ // Metoda Odejmowanie, odejmuje dwie cyfry
        double roznica = jeden - dwa;
        return(roznica);
    }

    static double Mnozenie(double jeden, double dwa){ // Metoda Mnozenie, mnoży dwie cyfry
        double iloczyn = jeden * dwa;
        return(iloczyn);
    }

    static double Dzielenie(double jeden, double dwa){ // Metoda Dzielenie, dzieli dwie cyfry
        double iloczyn = jeden / dwa;
        return(iloczyn);
    }

    static double Potegowanie(double jeden, double dwa){ // Metoda Potegowanie, potęguje dwie cyfry
        double power = pow(jeden,dwa);
        return(power);
    }

    static double PierwiastkowaniaDoKwadratu(double jeden){ // Metoda PierwiastkowaniaDoKwadratu, pierwiastkuje do kwadratu liczbe
        double pierwiastek = Math.sqrt(jeden);
        return(pierwiastek);
    }

    static double ProcentzLiczby(double jeden, double dwa){ // Metoda ProcentzLiczby, pokazuje procent z podanej liczby
        double procent = jeden * (dwa/100);
        return(procent);
    }

    static double Zerowanie(){ // Metoda Zerowanie, zeruje wynik jaki mamy na kalkulatorze
        double zero = 0;
        return(zero);
    }

    static boolean czyWartoscJestCyfra(String cyfra, double wynik) { // Metoda sprawdzająca czy wpisana wartość jest cyfrą
        double intValue;
        if(cyfra == null || cyfra.equals("")) {
            System.out.println("Wpisana wartosc jest pusta, zacznij od nowa!");
            Wybor_menu(11,wynik);
            return false;
        }
        try {
            intValue = Double.parseDouble(cyfra);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Wpisana wartosc nie jest cyfra, zacznij od nowa!");
            Wybor_menu(11, wynik);
        }
        return false;
    }

    static boolean czyCyfraJestDodatnia(String cyfra, double wynik) { // Metoda, która sprawdza czy wpisana liczba jest cyfrą i czy jest dodatnia
        double intValue;
        if(cyfra == null || cyfra.equals("")) {
            System.out.println("Wpisana wartosc jest pusta, ma byc liczba dodatnia, zacznij od nowa!");
            Wybor_menu(11, wynik);
            return false;
        }
        try {
            if ((intValue = Double.parseDouble(cyfra)) > 0 && (intValue = Double.parseDouble(cyfra)) < 11) {
                return true;
            }
            else {
                System.out.println("Wpisana wartość ma byc liczba z menu, zacznij od nowa!");
                intValue = 0;
                Wybor_menu(11, wynik);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wpisana wartosc ma byc cyfra, zacznij od nowa!");
            intValue = 0;
            Wybor_menu(11, wynik);
        }
        return false;
    }

    static double wpiszLiczbe(double wynik) { // Metoda wpiszLiczbe, pozwala na wpisanie liczby w konsoli, przerabia ją ze String na Double
        System.out.print("Wprowadz liczbe: ");
        Scanner scan = new Scanner(System.in); // Skanowanie liczby
        String liczba = scan.nextLine();
        if (czyWartoscJestCyfra(liczba, wynik)){
        }
        double liczbaInt = Double.parseDouble(liczba);
        wynik = liczbaInt;
        return wynik;
    }

    static void Error(double menu, double wynik){ // Metoda Error, powoduje powrót do Menu aby wybrać poprawny numer
        Wybor_menu(menu, wynik);
    }

    }

