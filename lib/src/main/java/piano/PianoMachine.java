package piano;



import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
    private ArrayList<Pitch> pitchesCollection = new ArrayList<>();
    private Instrument instrument = midi.DEFAULT_INSTRUMENT;
    private int shifting = 0;
    private String recording = "";
    private ArrayList<NoteEvent> recordingNote = new ArrayList<>();
    private Boolean isRecording = false;



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

        if(isRecording){
             recordingNote.add(new NoteEvent(rawPitch, System.currentTimeMillis()/10,instrument, NoteEvent.Kind.start));
        }
    }

    // stop to play note with instrument
    public void endNote(Pitch rawPitch) {
        if(!pitchesCollection.isEmpty() && pitchesCollection.contains(rawPitch)) {
            midi.endNote(rawPitch.toMidiFrequency()+(shifting*12),instrument);
            pitchesCollection.remove(rawPitch);
        }
        if(isRecording){
            recordingNote.add(new NoteEvent(rawPitch, System.currentTimeMillis()/10,instrument, NoteEvent.Kind.stop));
        }
    }

    //change the instrument instance
    public void changeInstrument() {
        instrument = instrument.next();
    }

    // shiftup pitch
    public void shiftUp() {
        if(shifting<2){
    	    shifting ++;
        }
    }
    
    // shiftdown pitch
    public void shiftDown() {
        if(shifting>-2) {
            shifting--;
        }
    }

    public boolean toggleRecording() {
        if(isRecording == false) {
            recordingNote.clear();
        }
        isRecording =!isRecording;
    	return isRecording;
    }
    
    //TODO write method spec
    public void playback() {    	
        for (int i =0; i<recordingNote.size();i++){
            NoteEvent noteEvent = recordingNote.get(i);

            if(noteEvent.getKind() == NoteEvent.Kind.start) midi.beginNote(noteEvent.getPitch().toMidiFrequency(),noteEvent.getInstr());
            else midi.endNote(noteEvent.getPitch().toMidiFrequency(),noteEvent.getInstr());

            if(i<recordingNote.size()-1){
                NoteEvent nextNoteEvent = recordingNote.get(i+1);
                int delay =(int)( nextNoteEvent.getTime() - noteEvent.getTime());
                Midi.rest(delay);
            }
        }
    }

}
