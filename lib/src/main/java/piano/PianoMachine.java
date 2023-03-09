package piano;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
    private ArrayList<Pitch> pitchesCollection = new ArrayList<>();
    private Instrument instrument = midi.DEFAULT_INSTRUMENT;
    private int shifting = 0;



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

    // begin to play note with instrument
    public void beginNote(Pitch rawPitch) {
        if(pitchesCollection.isEmpty()  || rawPitch.toMidiFrequency()!=pitchesCollection.get(0).toMidiFrequency()){
            pitchesCollection.add(rawPitch);
            midi.beginNote(rawPitch.toMidiFrequency() +(shifting*12),instrument);
        }
    }

    // stop to play note with instrument
    public void endNote(Pitch rawPitch) {
        if(!pitchesCollection.isEmpty() && pitchesCollection.contains(rawPitch)) {
            midi.endNote(rawPitch.toMidiFrequency()+(shifting*12),instrument);
            pitchesCollection.remove(rawPitch);
        }
    }

    //change the instrument instance
    public void changeInstrument() {
        instrument = instrument.next();
    }

    
    //TODO write method spec
    public void shiftUp() {
        if(shifting<2){
    	    shifting ++;
        }
    }
    
    //TODO write method spec
    public void shiftDown() {
        if(shifting>-2) {
            shifting--;
        }
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
