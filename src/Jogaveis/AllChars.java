package Jogaveis;

import java.util.Scanner;

public abstract class AllChars {

    //ATRIBUTOS CLASSE PAI
    static Scanner leia = new Scanner(System.in);
    private String nome;
    private int idade;
    private String sexo;
    private int vitality;
    private int resistance;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    //CONSTRUCTOR
    public AllChars(){}

    public AllChars(String nome, float peso, int idade,
                    String sexo, int vitality, int resistance,
                    int strength, int dexterity, int intelligence, int level) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.vitality = vitality;
        this.resistance = resistance;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.level = level;
    }


    //METODOS
    public void caminhar() throws InterruptedException {
        System.out.println("     ██     \n" +
                           "  ▄▀█▄▄▄     \n" +
                           "▄▀  █▄▄     \n" +
                           " ▄▄▄▀  ▀▄   \n" +
                           " ▀       ▀▀");
        Thread.sleep(2000);
        System.out.println("               ██     \n" +
                           "            ▄▀█▄▄▄     \n" +
                           "          ▄▀  █▄▄     \n" +
                           "           ▄▄▄▀  ▀▄   \n" +
                           "           ▀       ▀▀");
        Thread.sleep(2000);
        System.out.println("                          ██     \n" +
                           "                       ▄▀█▄▄▄     \n" +
                           "                     ▄▀  █▄▄     \n" +
                           "                      ▄▄▄▀  ▀▄   \n" +
                           "                      ▀       ▀▀");
        Thread.sleep(3000);
        System.out.println("                                     ██     \n" +
                           "                                  ▄▀█▄▄▄     \n" +
                           "                                ▄▀  █▄▄     \n" +
                           "                                 ▄▄▄▀  ▀▄   \n" +
                           "                                 ▀       ▀▀");

    }

    public String senioridade() {
        if (getIdade() >= 18 && getIdade() < 50) {
            return "jovem";
        } else if (getIdade() > 50) {
            return "senhor";
        }else if (getIdade() < 18 && getIdade() > 0){
            return "pequeno";
        }
        return null;
    }




    //GET AND SET
    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
