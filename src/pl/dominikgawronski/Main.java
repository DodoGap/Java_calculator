package pl.dominikgawronski;
import java.util.Scanner;

import static java.lang.Math.pow;


public class Main {

    static void Wybor_menu(double numer_menu, double wynik){
        switch ((int) numer_menu) {
            case 1:
                System.out.println("Wybrałeś/aś dodawanie.");
                double suma = Dodawanie(wynik, wpiszLiczbe(wynik));
                System.out.println("Suma: " + suma);
                Poczatek(suma);
                break;
            case 2:
                System.out.println("Wybrałeś/aś odejmowanie.");
                double roznica = Odejmowanie(wynik, wpiszLiczbe(wynik));
                System.out.println("Róznica: " + roznica);
                Poczatek(roznica);
            break;
            case 3:
                System.out.println("Wybrałeś/aś mnożenie.");
                double iloczyn = Mnozenie(wynik, wpiszLiczbe(wynik));
                System.out.println("Iloczyn: " + iloczyn);
                Poczatek(iloczyn);
                break;
            case 4:
                System.out.println("Wybrałeś/aś dzielenie.");
                double mianownik = wpiszLiczbe(wynik);
                while (mianownik == 0){
                    System.out.println("Nie można dzielić przez 0. Spróbuj jeszcze raz.");
                    mianownik = wpiszLiczbe(wynik);
                }
                double iloraz = Dzielenie(wynik, mianownik);
                System.out.println("Iloraz: " + iloraz);
                Poczatek(iloraz);
                break;
            case 5:
                System.out.println("Wybrałeś/aś potęgowanie.");
                System.out.println("Do jakiej potęgi chcesz podnieść " + wynik);
                double potega = wpiszLiczbe(wynik);
                double wynikpotegowania = Potegowanie(wynik, potega);
                System.out.println("Liczba " + wynik + " będzie podniesiona do potęgi " + potega);
                System.out.println("Wynik: " + wynikpotegowania);
                Poczatek(wynikpotegowania);
                break;
            case 6:
                System.out.println("Wybrałeś/aś pierwiastkowanie do kwadratu.");
                double pierwiastek = PierwiastkowaniaDoKwadratu(wynik);
                System.out.println("Pierwaistek drugiego stopnia z " + wynik + " = " + pierwiastek);
                Poczatek(pierwiastek);
                break;
            case 7:
                System.out.println("Wybrałeś/aś Procent z liczby.");
                System.out.print(" Wpisz ile procent z liczby " + wynik + " chciałbyś otrzymać. ");
                double procent = ProcentzLiczby(wynik,wpiszLiczbe(wynik));
                System.out.println("Procent z " + wynik + "to " + procent);
                Poczatek(procent);
                break;
            case 8:
                System.out.println("Wyzerowano wynik");
                wynik = Zerowanie();
                Poczatek(wynik);
                break;
            case 9:
                System.out.println("Program zamknie sie.");
                break;
            case 11:
                Poczatek(wynik);
                break;

        }
    }


    public static void main(String[] args) {
        System.out.println("Dzień dobry, przed Tobą prosty kalkulator.");
        double wynik = 0;
        double pierwsza_liczba = wpiszLiczbe(wynik);
        wynik = pierwsza_liczba;
        Poczatek(wynik);
    }

    static double Poczatek(double wynik) {
        double menu = 11;
        System.out.println("Możliwości kalkulatora: ");
        System.out.println("1. Dodawanie.");
        System.out.println("2. Odejmowanie.");
        System.out.println("3. Mnozenie.");
        System.out.println("4. Dzielenie.");
        System.out.println("5. Potęgowanie.");
        System.out.println("6. Pierwiastkowanie do kwadratu.");
        System.out.println("7. Obliczanie procentu z liczby.");
        System.out.println("8. Zerowanie.");
        System.out.println("9. Wyjscie.");
        System.out.println("Aktualna wawrtość kalkulatora: " + wynik);
        System.out.print("Wybierz co chcesz zrobić: ");
        Scanner scan = new Scanner(System.in);
        String wybrana_wartosc_z_menu = scan.nextLine();
        if (czyCyfraJestDodatnia(wybrana_wartosc_z_menu, wynik)) {
            double num_menu_double = Double.parseDouble(wybrana_wartosc_z_menu);
            Wybor_menu(num_menu_double, wynik);
        } else {
            Error(menu, wynik);
        }
        return(wynik);
    }

    static double Dodawanie(double jeden, double dwa){
        double suma = jeden + dwa;
        return(suma);
    }

    static double Odejmowanie(double jeden, double dwa){
        double roznica = jeden - dwa;
        return(roznica);
    }

    static double Mnozenie(double jeden, double dwa){
        double iloczyn = jeden * dwa;
        return(iloczyn);
    }

    static double Dzielenie(double jeden, double dwa){
        double iloczyn = jeden / dwa;
        return(iloczyn);
    }

    static double Potegowanie(double jeden, double dwa){
        double power = pow(jeden,dwa);
        return(power);
    }

    static double PierwiastkowaniaDoKwadratu(double jeden){
        double pierwiastek = Math.sqrt(jeden);
        return(pierwiastek);
    }

    static double ProcentzLiczby(double jeden, double dwa){
        double procent = jeden * (dwa/100);
        return(procent);
    }

    static double Zerowanie(){
        double zero = 0;
        return(zero);
    }

    static boolean czyWartoscJestCyfra(String cyfra, double wynik) {
        double intValue;
        if(cyfra == null || cyfra.equals("")) {
            System.out.println("Wpisana wartosc jest pusta, zacznij od nowa!");
            System.out.println("Wyzerowano wynik.");
            Wybor_menu(11,wynik);
            return false;
        }
        try {
            intValue = Double.parseDouble(cyfra);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Wpisana wartosc nie jest cyfra, zacznij od nowa!");
            System.out.println("Wyzerowano wynik.");
            Wybor_menu(11, wynik);
        }
        return false;
    }

    static boolean czyCyfraJestDodatnia(String cyfra, double wynik) {
        double intValue;
        if(cyfra == null || cyfra.equals("")) {
            System.out.println("Wpisana wartosc jest pusta, ma byc liczba dodatnia, zacznij od nowa!");
            System.out.println("Wyzerowano wynik.");
            Wybor_menu(11, wynik);
            return false;
        }
        try {
            if ((intValue = Integer.parseInt(cyfra)) > 0 && (intValue = Integer.parseInt(cyfra)) < 20) {
                return true;
            }
            else {
                System.out.println("Wpisana wartość ma byc liczba z menu, zacznij od nowa!");
                System.out.println("Wyzerowano wynik.");
                intValue = 0;
                Wybor_menu(11, wynik);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wpisana wartosc ma byc cyfra, zacznij od nowa!");
            System.out.println("Wyzerowano wynik.");
            intValue = 0;
            Wybor_menu(11, wynik);
        }
        return false;
    }

    static double wpiszLiczbe(double wynik) {
        System.out.print("Wprowadz liczbe: ");
        Scanner scan = new Scanner(System.in);
        String liczba = scan.nextLine();
        if (czyWartoscJestCyfra(liczba, wynik)){
        }
        double liczbaInt = Double.parseDouble(liczba);
        wynik = liczbaInt;
        return wynik;
    }

    static void Error(double menu, double wynik){
//        System.out.println("Wpisałeś złą wartość! Wybierz ponownie");
        Wybor_menu(menu, wynik);
    }

    }

