
package sudoko;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author vitor
 */
public class Sudoko {

   
    public static void main(String[] args) {
        //números preenchidos
        int P = 0;
        int jogo = 0;
        
        //Matriz
        int sudoko[][] = new int[9][9];
        
        JOptionPane.showMessageDialog(null, "SUDOKO!!!");
        P = Integer.parseInt(JOptionPane.showInputDialog("Digite a qtd. de números preenchidos"));
        String matrizS="";
            int L = 0;
            int C = 0;
            int N = 0;
        // ler os valores ja preenchidos
        for(int i=0; i<P; i++){
            
            
            N = Integer.parseInt(JOptionPane.showInputDialog(null,(i+1)+"º Número"));
            L = Integer.parseInt(JOptionPane.showInputDialog(null,(i+1)+"º Número\n Linha:"));
            C = Integer.parseInt(JOptionPane.showInputDialog(null,(i+1)+"º Nùmero\n Coluna"));
            
            sudoko[L-1][C-1] = N;
        }
        matrizS = matrizes(matrizS, sudoko);
        System.out.println(matrizS);
        
        
        
        while(jogo!=2){
            if(Venceu(sudoko)== true){
                
            }else{
                JOptionPane.showMessageDialog(null, matrizS);
                jogo = Integer.parseInt(JOptionPane.showInputDialog("1 - Jogar\n2 - Sair"));
            }
            
           
            if(jogo==2){
            
                JOptionPane.showMessageDialog(null, "Jogo finalizado");
                JOptionPane.showMessageDialog(null, matrizS);
                System.out.println("Jogo Finalizado");
            
        }else if(jogo==1){
                N = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite seu número"));
                L = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a Linha"));
                C = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a coluna"));
                
                 if(jogada(sudoko, N, L, C)== true){
                     sudoko[L-1][C-1] = N;
                     matrizS = matrizes(matrizS, sudoko);
                }else{
                     sudoko[L-1][C-1] = 0;
                 }
                 
            }
   
        }
        
    }

    public static boolean jogada(int sudoko[][], int N, int L, int C) {
            
            int y =0;
            int z=0;
            //String m = "";
            int jogar[] = new int[3];
            jogar[0] = N;
            jogar[1] = L;
            jogar[2] = C;
            //m = matrizes(m, sudoko);
            //System.out.println(m);
            if(jogar[0] == sudoko[L-1][C-1]){
                
                JOptionPane.showMessageDialog(null, "Valor inválido");
                y++;
                
            }
             

            //verifica se possui valor igual nas linhas
            for(int i=0; i<9;i++){
                
                if(jogar[0] == sudoko[L-1][i]){
                    y++;//se for igual ele adiciona o contador
                }
            }
            
             //verifica se possui valor igual nas colunas
             for(int i=0; i<9;i++){
                if(jogar[0]== sudoko[i][C]){
                    z++;//se for igual ele adiciona o contador
                }
            }
             
             //submatriz
             if (L % 3 == 0) {
                for (int lin = 0; lin <= 2; lin++) {
                    if (C % 3 == 0)
                        for (int col = 0; col <= 2; col++)
                            if (sudoko[L+lin][C+col] == N) {
                                System.out.println("Jogada Invalida\n");
                            y++;
                        }
                    if (C % 3 == 1)
                        for (int col = 0; col <= 2; col++)
                            if (sudoko[L+lin][(C-1)+col] == N) {
                                System.out.println("Jogada Invalida\n");
                                y++;
                        }
                    if (C % 3 == 2)
                        for (int col = 0; col <= 2; col++)
                            if (sudoko[L+lin][(C-2)+col] == N) {
                                System.out.println("Jogada Invalida\n");
                            y++;
                        }
                    }
                }
                if (L % 3 == 1) {
                    for (int lin = 0; lin <= 2; lin++) {
                        if (C % 3 == 0)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-1)+lin][C+col] == N) {
                                    System.out.println("Jogada Invalida\n");
                                    y++;
                        }
                        if (C % 3 == 1)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-1)+lin][(C-1)+col] == N) {
                                 System.out.println("Jogada Invalida\n");
                                 y++;
                        }
                        if (C % 3 == 2)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-1)+lin][(C-2)+col] == N) {
                                    System.out.println("Jogada Invalida\n");
                                    y++;
                        }
                    }
                }
                if (L % 3 == 2) {
                    for (int lin = 0; lin <= 2; lin++) {
                        if (C % 3 == 0)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-2)+lin][C+col] == N) {
                                    System.out.println("Jogada Invalida\n");
                                   y++;
                        }
                        if (C % 3 == 1)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-2)+lin][(C-1)+col] == N) {
                                    System.out.println("Jogada Invalida\n");
                                    y++;
                        }
                        if (C % 3 == 2)
                            for (int col = 0; col <= 2; col++)
                                if (sudoko[(L-2)+lin][(C-2)+col] == N) {
                                    System.out.println("Jogada Invalida\n");
                                    y++;
                        }
                    }
                }
                
                
            if(y>0 || z>0){//com o contador maior q 0 a jogada é falsa
                 System.out.println("y="+y);
                 System.out.println("z="+z);
                  JOptionPane.showMessageDialog(null, "Valor inválido");
                  System.out.println("Valor inválido");
                return false;
            }
            
        return true;
    }
    public static String matrizes(String s, int sudoko[][]){
        s = "";
         for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                
                s += sudoko[i][j]+"     ";
            }
            s+="\n";
        }
        return s;
    }
    public static boolean Venceu(int sudoko[][]){
        int y = 0;
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
               if(sudoko[i][j]== 0){
                   return false;
               }else{
                   y++;
               } 
               
            }
            
        }
        if(y>81){
            return true;
        }
        
       return true; 
    }
   
}
