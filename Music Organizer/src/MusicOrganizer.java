import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;


public class MusicOrganizer
{
    //-----------------------------------instances-variables--------------------------------||
    private String audioFileName;
    private Player audioPlayer;

    //--------------------------------------Static Block------------------------------------||
    /**
     * static block can be used for static initializations of a class.
     * This code inside static block is executed only once:
     * the first time the class is loaded into memory.
     * And in this block,Audio list will display on top of console
     */
    static
    {
        System.out.println("=================================================");
        System.out.println("        ******** Music Organizer ********");
        System.out.println("1. Alan Walker - Faded");
        System.out.println("2. Circle");
        System.out.println("3. Maroon 5 - Girls Like You ft. Cardi B");
        System.out.println("4. Ed Sheeran - Shape Of You");
        System.out.println("5. Humraah - Malang");
        System.out.println("6. Malang - Title Track");
        System.out.println("7. Akh Lad Jave - Loveratri");
        System.out.println("8. Raat-Bhar");
        System.out.println("9. Tera Hua by Atif Aslam");
        System.out.println("10.Tera Hua (Loveyatri - A Journey Of Love)");
        System.out.println("=================================================");
    }


    //---------------------------------------constructor--------------------------------------||
    public MusicOrganizer()
    {

    }

    //----------------------------------------close-Audio-Player------------------------------||
    //closeAudioPlayer method will close audio player by calling.
    public void closeAudioPlayer()
    {
        if (audioPlayer != null)
        {
            audioPlayer.close();
        }
    }

    //-------------------------------------------play-Audio-Player----------------------------||
    // playAudioPlayer method will play Audio of MP3 format.
    public void playAudioPlayer()
    {
        try {
            FileInputStream readFile     = new FileInputStream(audioFileName);
            BufferedInputStream readInfo = new BufferedInputStream(readFile);
            audioPlayer = new Player(readInfo);
        }
        catch (Exception ex)
        {
            System.out.println("File is not supported, PROBLEM !! " + audioFileName);
            System.out.println(ex);
        }

        // run method with thread will run Audio in Background
        new Thread()
        {
            public void run()
            {
                try
                {
                    audioPlayer.play();
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }.start();
    }

    //---------------------------------------------Select-Audio-------------------------------||
    //Audio will select and selectAudio will return us audioFileName to play Audio.
    public void selectAudio(int audioNumber)
    {
        switch (audioNumber)
        {
            case 1: {
                System.out.println("****Alan Walker IS playing Now!****");
                this.audioFileName = "audio\\Alan Walker - Faded.mp3";
                break;
            }
            case 2:
            {
                System.out.println("****Circle IS playing Now!****");
                this.audioFileName = "audio\\Circle.mp3";
                break;
            }
            case 3:
            {
                System.out.println("****Maroon - Girls like you - Title Track IS playing Now!****");
                this.audioFileName = "audio\\Maroon 5 - Girls Like You ft. Cardi B.mp3";
                break;
            }
            case 4:
            {
                System.out.println("****Ed Sheeran - Shape Of You IS playing Now!****");
                this.audioFileName = "audio\\Ed Sheeran - Shape Of You.mp3";
                break;
            }
            case 5:
            {
                System.out.println("****Humraah - Malang IS playing Now!****");
                this.audioFileName = "audio\\Humraah - Malang.mp3";
                break;
            }
            case 6:
            {
                System.out.println("****Malang - Title Track IS playing Now!****");
                this.audioFileName = "audio\\Malang - Title Track.mp3";
                break;
            }

            case 7:
            {
                System.out.println("****Akh Lad Jave - Loveratri IS playing Now!****");
                this.audioFileName = "audio\\Akh Lad Jave - Loveratri.mp3";
                break;
            }
            case 8:
            {
                System.out.println("****Raat-Bhar IS playing Now!****");
                this.audioFileName = "audio\\Raat-Bhar.mp3";
                break;
            }
            case 9:
            {
                System.out.println("****Tera Hua By Atif Aslam IS playing Now!****");
                this.audioFileName = "audio\\Tera Hua (Loveyatri - A Journey Of Love) (1).mp3";
                break;
            }
            case 10:
            {
                System.out.println("****Tera Hua (Loveyatri - A Journey Of Love) IS playing Now!****");
                this.audioFileName = "audio\\Tera Hua (Loveyatri - A Journey Of Love) (2).mp3";
                break;
            }
            default:
            {
                System.out.println("Invalid!");
                break;
            }
        }
    }

    //--------------------------------------------MAIN-METHOD---------------------------------||
    public static void main(String[] args)
    {
        //local variable.
        int audioNumber;

        // use scanner class to take input from user.
        Scanner sc = new Scanner(System.in);
        System.out.print("Plz, select music : ");
        audioNumber = sc.nextInt();

        //make object.
        MusicOrganizer audioObj = new MusicOrganizer();

        //invoke method.
        audioObj.selectAudio(audioNumber);
        audioObj.playAudioPlayer();

        //below statements/condition will stop Audio Player.
        System.out.print("Enter 0 to stop! : ");
        int a = sc.nextInt();
        if (a == 0) {
            audioObj.closeAudioPlayer();
        }
    }

}
//-------------------------------------------------------------------------------------------------||