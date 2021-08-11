import System.IO

euclideanAlgorithm :: Integral t => t -> t -> t
euclideanAlgorithm a b = 
    if b == 0 -- base case
        then  a -- GCD
    else
        euclideanAlgorithm b (mod a b) -- recurse back

main :: IO ()
main = do
    putStrLn "Enter Number A :"
    numberA <- getLine 
    putStrLn "Enter Number B :"
    numberB <- getLine 
    let a = (read numberA :: Int)
    let b = (read numberB :: Int)
    putStrLn "GCD is : "
    putStrLn ( show (euclideanAlgorithm a b) :: String)