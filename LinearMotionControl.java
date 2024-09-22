import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Linear Motion Control", group="Lift")
public class LinearMotionControl extends LinearOpMode {

   
    private DcMotor linearMotor;

    @Override
    public void runOpMode() {
        
        linearMotor = hardwareMap.get(DcMotor.class, "linear_motor");

        
        linearMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        
        linearMotor.setDirection(DcMotor.Direction.FORWARD);

       
        waitForStart();

        while (opModeIsActive()) {
            
            double liftPower = 0.0;

            if (gamepad1.right_trigger > 0.1) {
               
                liftPower = gamepad1.right_trigger; 
            } else if (gamepad1.left_trigger > 0.1) {
                
                liftPower = -gamepad1.left_trigger; 
            }

            
            linearMotor.setPower(liftPower);

            
            telemetry.addData("Lift Power", liftPower);
            telemetry.update();
        }
    }
}