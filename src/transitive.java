// Program untuk transitive closure using  warshall

public class transitive {

    final static int V = 4 ;

    // Mencetak grafik transitif closure[][] menggunakan 
    // Algoritma Warshall
    void transitiveClosure(int graph[][])
    {
        /* reach[][] akan menjadi output matriks yang akhirnya
        memiliki jarak terpendek antara setiap pasangan
        sudut */
        int reach[][] = new int [V][V];
        int i,j,k;

        /* Inisialisasi matriks solusi sama dengan grafik input
        matriks. Atau kita dapat mengatakan nilai awal terpendek
        jarak didasarkan pada jalur terpendek dengan mempertimbangkan
        tidak ada titik tengah. */
        for( i = 0; i<V; i++)
            for(j = 0; j<V;j++)
                reach[i][j] = graph[i][j];

        /* Tambahkan semua simpul satu per satu ke himpunan perantara
        sudut.
        ---> Sebelum memulai pengulangan, kami memiliki keterjangkauan
        nilai untuk semua pasangan simpul sedemikian rupa sehingga
        nilai keterjangkauannya hanya mempertimbangkan simpul di
        atur {0, 1, 2, .. k-1} sebagai simpul perantara.
        ----> Setelah akhir iterasi, simpul no. k adalah
        ditambahkan ke himpunan simpul perantara dan
        himpunan menjadi {0, 1, 2, .. k} */
        for (k = 0 ; k<V;k++)
        {
            // Pilih semua simpul sebagai sumber satu per satu
            for ( i=0;i<V;i++)
            {
                // Pilih semua simpul sebagai tujuan untuk
                // sumber yang dipilih di atas
                for( j = 0 ; j<V;j++)
                {
                    // Jika simpul k berada pada lintasan dari i ke j,
                    // lalu pastikan nilai reach[i][j] adalah 1
                    reach[i][j] = (reach[i][j]!=0) ||
                        ((reach[i][k]!=0)&&(reach[k][j]!=0))?1:0;
                }
            }
        }
        // Cetak matriks jarak terpendek
        printSolution(reach);  
    }

    /* Fungsi untuk mencetak solusi */
    void printSolution ( int reach[][])
    {
        System.out.println("Matriks berikut adalah penutupan transitif "+" dari grafik yang diberikan");
        for (int i =0; i < V; i++)
        {
            for(int j = 0; j<V; j++)
            {
                if(i==j)
                    System.out.print("0 ");
                else
                    System.out.print(reach[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        
        /* Mari kita buat graf
        (1)------>(2)
                   |
                   |
                   | 
                  \|/
        (4)<------(3)
                      */

        int graph[][] = new int[][]{{0,1,0,0},
                                    {0,0,1,0},
                                    {0,0,0,1},
                                    {0,0,0,0}};
                                    
        transitive g = new transitive();
        g.transitiveClosure(graph);
     


    }
}
