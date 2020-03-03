# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'c:\Users\ABC\Documents\GitHub\Prog1700-Student25\Tech Checks\TC7\TC7Calculator.ui'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_TC7Calculator(object):
    def setupUi(self, TC7Calculator):
        TC7Calculator.setObjectName("TC7Calculator")
        TC7Calculator.resize(313, 269)
        self.centralwidget = QtWidgets.QWidget(TC7Calculator)
        self.centralwidget.setObjectName("centralwidget")
        self.result = QtWidgets.QLabel(self.centralwidget)
        self.result.setGeometry(QtCore.QRect(40, 200, 231, 51))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(10)
        self.result.setFont(font)
        self.result.setText("")
        self.result.setAlignment(QtCore.Qt.AlignLeading|QtCore.Qt.AlignLeft|QtCore.Qt.AlignTop)
        self.result.setObjectName("result")
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(20, 200, 21, 21))
        self.label_2.setObjectName("label_2")
        self.methodBox = QtWidgets.QComboBox(self.centralwidget)
        self.methodBox.setGeometry(QtCore.QRect(20, 100, 131, 22))
        font = QtGui.QFont()
        font.setFamily("Arial")
        self.methodBox.setFont(font)
        self.methodBox.setObjectName("methodBox")
        self.methodBox.addItem("")
        self.methodBox.addItem("")
        self.methodBox.addItem("")
        self.methodBox.addItem("")
        self.methodBox.addItem("")
        self.methodBox.addItem("")
        self.label_3 = QtWidgets.QLabel(self.centralwidget)
        self.label_3.setGeometry(QtCore.QRect(20, 10, 201, 31))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(14)
        font.setBold(True)
        font.setWeight(75)
        self.label_3.setFont(font)
        self.label_3.setObjectName("label_3")
        self.calc_btn = QtWidgets.QPushButton(self.centralwidget)
        self.calc_btn.setGeometry(QtCore.QRect(190, 50, 101, 121))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(10)
        self.calc_btn.setFont(font)
        self.calc_btn.setObjectName("calc_btn")
        self.xnum = QtWidgets.QLineEdit(self.centralwidget)
        self.xnum.setGeometry(QtCore.QRect(20, 50, 151, 31))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(10)
        self.xnum.setFont(font)
        self.xnum.setObjectName("xnum")
        self.ynum = QtWidgets.QLineEdit(self.centralwidget)
        self.ynum.setGeometry(QtCore.QRect(20, 140, 151, 31))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(10)
        self.ynum.setFont(font)
        self.ynum.setObjectName("ynum")
        TC7Calculator.setCentralWidget(self.centralwidget)

        self.retranslateUi(TC7Calculator)
        QtCore.QMetaObject.connectSlotsByName(TC7Calculator)

    def retranslateUi(self, TC7Calculator):
        _translate = QtCore.QCoreApplication.translate
        TC7Calculator.setWindowTitle(_translate("TC7Calculator", "TC7 Calculator"))
        self.label_2.setText(_translate("TC7Calculator", "="))
        self.methodBox.setItemText(0, _translate("TC7Calculator", "+"))
        self.methodBox.setItemText(1, _translate("TC7Calculator", "-"))
        self.methodBox.setItemText(2, _translate("TC7Calculator", "*"))
        self.methodBox.setItemText(3, _translate("TC7Calculator", "/"))
        self.methodBox.setItemText(4, _translate("TC7Calculator", "%"))
        self.methodBox.setItemText(5, _translate("TC7Calculator", "x to yth power"))
        self.label_3.setText(_translate("TC7Calculator", "TC7 Calculator"))
        self.calc_btn.setText(_translate("TC7Calculator", "Calculate"))

