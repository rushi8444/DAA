#include <iostream>
using namespace std;
// Recursive function to calculate Fibonacci using if-else
int fibonacci(int x)
{
    if (x == 0 || x == 1)
    {
        return x;
    }
    else
    {
        return fibonacci(x - 1) + fibonacci(x - 2);
    }
}
int main()
{
    int terms = 10;
    cout << "Fibonacci Series using recursion and if-else: ";
    for (int i = 0; i < terms; i++)
    {
        cout << fibonacci(i) << " ";
    }
    return 0;
}






// C++ program to generate Fibonacci sequence up to n terms
#include <iostream>
using namespace std;
// Class to generate Fibonacci sequence
class Fibonacci
{
public:
    // Function to generate Fibonacci sequence up to n terms
    void generate(int n)
    {
        if (n <= 0)
        {
            cout << "Please enter a positive integer." << endl;
            return;
        }
        int first = 0, second = 1;
        cout << "Fibonacci Sequence: ";
        for (int i = 1; i <= n; i++)
        {
            cout << first << " ";
            // Calculate the next term
            int next = first + second;
            first = second;
            second = next;
        }
        cout << endl;
    }
};
int main()
{
    // Initialize a Fibonacci object
    Fibonacci fibonacci;
    int n;
    while (1)
    {
        cout << "\n**** MENU ****";
        cout << "\n1: Generate Fibonacci Sequence 2: EXIT";
        cout << "\nEnter Your Choice: ";
        int ch;
        cin >> ch;
        switch (ch)
        {
        case 1:
            cout << "Enter the number of terms: ";
            cin >> n;
            fibonacci.generate(n);
            break;
        case 2:
            return 0;
        default:
            cout << "Invalid choice. Please try again." << endl;
        }
    }
    return 0;
}