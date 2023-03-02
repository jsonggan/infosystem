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
    private static Instrument instrument = Instrument.PIANO;

    public static void main(String[] args) {
        for (int i =0 ; i<5;i++){
            System.out.println(instrument);
            instrument = instrument.next();}
    }

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
        //1. make sure instrument state is changing in piano machine
//        instrument = instrument.next();
//        for (Pitch pitch: pitchesCollection){
//            midi.beginNote(pitch.toMidiFrequency(),instrument);
//            midi.endNote(pitch.toMidiFrequency(),instrument);
//
//        }


        // Get the current set of pitches
        List<Pitch> currentPitches = new ArrayList<>(pitchesCollection);

        // Stop playing all notes using the current instrument
        for (Pitch pitch : currentPitches) {
            midi.endNote(pitch.toMidiFrequency(), instrument);
        }
        instrument = instrument.next();
        // Play all notes using the new instrument
        for (Pitch pitch : currentPitches) {
            midi.beginNote(pitch.toMidiFrequency(), instrument);
        }

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
