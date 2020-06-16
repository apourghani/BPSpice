import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitialTextProccesor {
    File file;
    ArrayList<Element> elements=new ArrayList<Element>();

   InitialTextProccesor(File file){
       this.file=file;
   }


    public void start(){
       String currentLineInput;
       int lineNumber=1;

        try {
            Scanner fileScan = new Scanner(file);
            currentLineInput=fileScan.nextLine();


            while (fileScan.hasNextLine()) {

                if (currentLineInput.charAt(0)=='*')
                    star();

                else if(currentLineInput.charAt(0)=='i'||currentLineInput.charAt(0)=='I')
                    createCurrentSource(currentLineInput);

                else if(currentLineInput.charAt(0)=='c'||currentLineInput.charAt(0)=='C')
                    createCapacitor(currentLineInput);

                else if(currentLineInput.charAt(0)=='l'||currentLineInput.charAt(0)=='L')
                    createInductor(currentLineInput);

                else if (currentLineInput.charAt(0)=='g'||currentLineInput.charAt(0)=='G')
                    createCurrentControledCurrentSource(currentLineInput);

                else if(currentLineInput.charAt(0)=='f'||currentLineInput.charAt(0)=='F')
                    createVoltageControledCurrentSource(currentLineInput);

                else if(currentLineInput.charAt(0)=='v'||currentLineInput.charAt(0)=='V')
                    createVoltageSource(currentLineInput);

                else if(currentLineInput.charAt(0)=='h'||currentLineInput.charAt(0)=='H')
                    createCurrentControledVoltageSource(currentLineInput);

                else if(currentLineInput.charAt(0)=='e'||currentLineInput.charAt(0)=='E')
                    createVoltageControledVoltageSource(currentLineInput);

                else if ((currentLineInput.charAt(0)=='d'||currentLineInput.charAt(0)=='D')
                        &&!(currentLineInput.charAt(1)=='v'||currentLineInput.charAt(1)=='V')
                        &&!(currentLineInput.charAt(1)=='i'||currentLineInput.charAt(1)=='I'
                        &&!(currentLineInput.charAt(1)=='t'||currentLineInput.charAt(1)=='T')))
                    createIdealDiode(currentLineInput);

                else if(currentLineInput.indexOf("DV")==0||currentLineInput.indexOf("dV")==0
                ||currentLineInput.indexOf("dv")==0||currentLineInput.indexOf("Dv")==0)
                    setVoltagetick(currentLineInput);

                else if(currentLineInput.indexOf("di")==0||currentLineInput.indexOf("dI")==0
                        ||currentLineInput.indexOf("Di")==0||currentLineInput.indexOf("DI")==0)
                    setCurrenttick(currentLineInput);

                else if(currentLineInput.indexOf("dt")==0||currentLineInput.indexOf("dT")==0
                        ||currentLineInput.indexOf("Dt")==0||currentLineInput.indexOf("DT")==0)
                    setTimetick(currentLineInput);

                else if(currentLineInput.indexOf(".tran")==0)
                    setEndTime(currentLineInput);

                currentLineInput=fileScan.nextLine();
                lineNumber++;

            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public void star(){
       //Do Nothing :)
    }

    public void createCurrentSource(String currentLineInput){

       elements.add(new CurrentSource(currentLineInput));

    }

    public void createCapacitor(String currentLineInput){
        elements.add(new Capacitor(currentLineInput));
    }

    public void createInductor(String currentLineInput){
        elements.add(new Inductor(currentLineInput));
    }
    public void createCurrentControledCurrentSource(String currentLineInput){
        elements.add(new CurrentControledCurrentSource(currentLineInput));
    }
    public void createVoltageControledCurrentSource(String currentLineInput){
        elements.add(new VoltageControledCurrentSource(currentLineInput));
    }
    public void createVoltageSource(String currentLineInput){
        elements.add(new VoltageSource(currentLineInput));
    }
    public void createCurrentControledVoltageSource(String currentLineInput){
        elements.add(new CurrentControledVoltageSource(currentLineInput));
    }
    public void createVoltageControledVoltageSource(String currentLineInput){
        elements.add(new VoltageControledCurrentSource(currentLineInput));
    }
    public void createIdealDiode(String currentLineInput){
        elements.add(new IdealDiode(currentLineInput));
    }
    public void setCurrenttick(String currentLineInput){

    }
    public void setVoltagetick(String currentLineInput){

    }
    public void setTimetick(String currentLineInput){

    }
    public void setEndTime(String currentLineInput){

    }

}
