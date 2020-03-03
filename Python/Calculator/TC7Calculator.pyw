import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox

import Ui_TC7Calculator

class MyForm(QMainWindow, Ui_TC7Calculator.Ui_TC7Calculator):
    #DON'T Touch!
    def __init__(self, parent=None):
        super(MyForm,self).__init__(parent)
        self.setupUi(self)
    #END DON'T touch
        self.calc_btn.clicked.connect(self._calc)
        self.calc_btn.clicked.connect(self._calc)
    
    #Responses Here
    def _calc(self):
        try:
            x = self.xnum.text()
            y = self.ynum.text()
            oper = self.methodBox.currentText()
            x = float(x)
            y = float(y)
            if oper == "+":
                result = x + y 
            elif oper == "-":
                result = x - y
            elif oper == "*":
                result = x * y
            elif oper == "/":
                result = x / y
            elif oper == "%":
                result = x % y
            else:
                result = x ** y
            
            self.result.setText("{0:.10f}".format(result))
        except ValueError:
            QMessageBox.information(self,"Warning!","It not a valid input.")
            self.xnum.clear()
            self.ynum.clear()


#Don't Touch
if __name__ == "__main__":
    app = QApplication(sys.argv)
    the_form = MyForm()
    the_form.show()
    sys.exit(app.exec_())