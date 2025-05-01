package april_2025;

public class SimpleCalculator {

    // O(n) time | O(n) space
    public int calculate(String expression) {
        return eval_helper(expression, 0)[0];
    }

    private int[] eval_helper(String expression, int index) {
        char op = '+';
        int[] res = new int[2];
        int result = 0;

        while (index < expression.length()) {
            char c = expression.charAt(index);

            // Jeśli napotkamy operator + lub -, zaktualizuj operator
            if (c == '+' || c == '-') {
                op = c;
                index++; // Przechodzimy do kolejnego znaku
            }
            // Jeśli napotkamy cyfrę, musimy rozpoznać pełną liczbę
            else if (Character.isDigit(c)) {
                int value = 0;
                // Odczytujemy całą liczbę, która może mieć więcej niż jedną cyfrę
                while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                    value = value * 10 + Character.getNumericValue(expression.charAt(index));
                    index++;
                }
                // Dodajemy lub odejmujemy liczbę w zależności od operatora
                if (op == '+') {
                    result += value;
                } else if (op == '-') {
                    result -= value;
                }
            }
            // Jeśli napotkamy nawias otwierający, rekurencyjnie obliczamy zawartość nawiasu
            else if (c == '(') {
                int[] recRes = eval_helper(expression, index + 1);  // Rekurencyjnie obliczamy zawartość nawiasu
                int value = recRes[0];
                index = recRes[1];  // Aktualizujemy index po zakończeniu obliczeń wewnątrz nawiasu
                // Dodajemy lub odejmujemy wynik z nawiasu w zależności od operatora
                if (op == '+') {
                    result += value;
                } else if (op == '-') {
                    result -= value;
                }
            }
            // Jeśli napotkamy nawias zamykający, kończymy obliczenia w obrębie nawiasu
            else if (c == ')') {
                res[0] = result;
                res[1] = index + 1;  // Kończymy obliczenia po zamknięciu nawiasu
                return res;
            }
            // Inne przypadki (spacje lub inne znaki), po prostu pomijamy
            else {
                index++;
            }
        }

        res[0] = result;
        res[1] = index;
        return res;
    }

}
