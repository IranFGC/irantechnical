import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Drum Spinner Control", group="Spinner")
public class DrumSpinnerControl extends LinearOpMode {

    
    private DcMotor drumSpinnerMotor;

    @Override
    public void runOpMode() {
        
        drumSpinnerMotor = hardwareMap.get(DcMotor.class, "drum_spinner_motor");

        
        drumSpinnerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        
        drumSpinnerMotor.setDirection(DcMotor.Direction.FORWARD);

        
        waitForStart();

        while (opModeIsActive()) {
            
            if (gamepad1.a) {
                
                drumSpinnerMotor.setPower(1.0); 
            } else if (gamepad1.b) {
                
                drumSpinnerMotor.setPower(-1.0); 
            } else if (gamepad1.x) {
                
                drumSpinnerMotor.setPower(0.0); 
            }

            
            telemetry.addData("Spinner Power", drumSpinnerMotor.getPower());
            telemetry.update();
        }
    }
}