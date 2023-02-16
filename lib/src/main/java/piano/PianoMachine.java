package piano;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
    private ArrayList<Pitch> pitchesCollection = new ArrayList<>();

	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        if(pitchesCollection.isEmpty()  || rawPitch.toMidiFrequency()!=pitchesCollection.get(0).toMidiFrequency()){
            pitchesCollection.add(rawPitch);
            midi.beginNote(rawPitch.toMidiFrequency());
        }
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        if(!pitchesCollection.isEmpty() && pitchesCollection.contains(rawPitch)) {
            midi.endNote(rawPitch.toMidiFrequency());
            pitchesCollection.remove(rawPitch);
        }
    }

    //TODO write method spec
    public void changeInstrument() {
       	//TODO: implement for question 2
    }
    
    //TODO write method spec
    public void shiftUp() {
    	//TODO: implement for question 3
    }
    
    //TODO write method spec
    public void shiftDown() {
    	//TODO: implement for question 3
    }
    
    //TODO write method spec
    public boolean toggleRecording() {
    	return false;
    	//TODO: implement for question 4
    }
    
    //TODO write method spec
    public void playback() {    	
        //TODO: implement for question 4
    }

}
