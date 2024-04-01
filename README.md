# Úkol 7 – Knihovna

Implementujte jednoduchou aplikaci pro evidenci knížek. Aplikace nače seznam knížek z JSON souboru a bude umět vypsat všechny knížky od zvoleného autora a také
všechny knížky vydané v zadaném roce.

Nemusíte dodržet přesné pořadí kroků uvedených níže – např. se může hodit napsat si test před implementací nkódu, který bude testovat, nebo souběžně s ním.

1. Aplikace bude obsahovat vedle třídy `Aplikace` už jen dvě další třídy, `Kniha` a `KnihaSluzba`. Obě nové třídy proto vytvořte přímo v
   package `cz.czechitas.ukol07`.
1. Třída `Kniha` bude JavaBean a bude reprezentovat jednu knížku. Podívejte se na strukturu JSON souboru `src/main/resources/cz/czechitas/ukol07/knihy.json` a
   strukturu třídy (properties) navhněte podle struktury JSON souboru.
2. Ve třídě `KnihaSluzba` bude field typu `List<Kniha>`. Obsah tohoto souboru naplňte v konstruktoru třídy. Pro načtení použijte `ObjectMapper`.
    1. Pro načtení použijte `InputStream`, který vytvoříte voláním `KnihaSluzba.class.getResourceAsStream("knihy.json")`. Tímto způsobem načtetesoubor
       knihy.json, který je uložen
       v `src/main/java` ve stejném package, jako třída `KnihaSluzba`. Nezapomeňte, že `InputStream` se musí po dokončení zavřít – použijte
       konstrukci `try-with-resources`.
    1. Pro samotné načtení `List`u použijte následující konstrukci:
       ```java
       objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>(){})
       ```
       Kód `objectMapper.readValue(inputStream, List<Kniha>.class)` z historických důvodů nejde použít. Pokud potřebujete načíst kolekci nebo jakýkoli jiný
       generický typ, je potřeba použít konstrukci s třídou `TypeReference`.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih od zadaného autora (jméno autora bude parametr metody).
   Vrácený seznam může být prázdný.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih vydaných v zadaném roce (rok bude parametr metody).
   Vrácený seznam může být prázdný.
1. Napište testy pro metody ve třídě `KnihaSluzba`. Nezapomeňte otestovat i okrajové případy – metoda pro výběr knih dle autora nebo orku nevrátí žádnou knížku
   nebo vrátí více knih.
1. Ve třídě Aplikace vytvořte spouštěcí metodu `main`. V této metodě vytvořte instanci třídy `KnihaSluzba`.
1. Vypište do konzole (pomocí `System.out`) celkový počet knížek v naší malé databázi.
1. Vypište do konzole názvy všech knížek, které napsal Karel Čapek.
1. Vypište všechny knížky vydané poprvé v roce 1845. Výpis bude ve tvaru *jméno autora: název knihy*.

## Bonus

1. Jako bonus můžete validovat hodnoty předávané do setterů třídy `Kniha`. Pokud je parametr chybný, je vhodné vyhodit výjimku `IllegalArgumentException`:
    1. Jméno autora by nemělo být prázdné (`null` ani prázdný String).
    1. Název knihy by neměl být prázdný (`null` ani prázdný String).
    1. Budeme uvažovat pouze tištěné knihy, takže rok vydání by neměl být starší, než je vynález knihtisku – použijte jako hraniční rok 1440.
1. Implementujte testy na validace implementované v setterech – tj. zda správné hodnoty projdou a chybné neprojdou (vyhodí výjimku).
