package ceres.input.rsbehavior;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadTxt implements ReadSchemaBehavior{

 private FileReader fileReader;
 private BufferedReader bufferReader;
 // seta o separador
 private char tab;
 //seta o tipo de leitura
 // 1 = com separador
 // 2 = com um limites
 private int type;
 //array com os limiteadores
 // array(inicio, fim)
 private ArrayList<int[]> limits;

 //contrutor para o caso do arquivo trabalhar com separadores
 public ReadTxt(char tab){
  this.tab = tab;
  this.type = 1;
 }
 //contrutor para o caso do arquivo trabalhar com limites
 public ReadTxt(ArrayList<int[]> limits){
  this.limits = limits;
  this.type = 2;
 }

    public void read(File arquivo) {
     try {
   this.fileReader = new FileReader(arquivo);
  } catch (FileNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  this.bufferReader = new BufferedReader(fileReader);

  String line;
  try {
   while((line = this.bufferReader.readLine()) != null){
    if(this.type == 1)
     readWithTab();
    else
     readWithLimits();

   }
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

    }
 private void readWithLimits() {
  // TODO Auto-generated method stub

 }
 private void readWithTab() {
  // TODO Auto-generated method stub

 }

}