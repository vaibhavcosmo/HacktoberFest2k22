#include <iostream>
#include <stack>
using namespace std;

int main() {

  // create a stack of strings
  stack<string> colors;

  // push elements into the stack
  colors.push("Red");
  colors.push("Orange");
  
  cout << "Stack: ";

  // print elements of stack
   while(!colors.empty()) {
    cout << colors.top() << ", ";
    colors.pop();
  }
 
  return 0;
}
