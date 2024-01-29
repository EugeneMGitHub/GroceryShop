package com.example.groceryshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshop.ui.theme.GroceryShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Surface(color = MaterialTheme.colorScheme.background){
                    HomeScreen()
                }
            }

//            MainTheme {
//                HomeScreen()
//            }
        }
    }
}


@Composable
fun MainTheme(content: @Composable () -> Unit){
    Surface(color = MaterialTheme.colorScheme.background){
        content
    }
}

@Composable
fun HomeScreen(
){

//    Column() {
//        Text(text = "dasfsdf")
//    }

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())){

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, -(30).dp)
            ,
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column {
            AppBar()
            Content()
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
   Row(
       Modifier
           .padding(16.dp)
           .height(48.dp),
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceAround
   ){
        TextField(
            value = "",
            onValueChange = {},
            label = {Text(text = "Search Food, Vegetable, etc.", fontSize = 12.sp)},
            singleLine = true,
            leadingIcon = {Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
       Spacer(modifier = Modifier.width(8.dp))
       IconButton(
           onClick = {}
       ) {
           Icon(
               imageVector = Icons.Outlined.FavoriteBorder,
               contentDescription = "",
               tint = Color.White,)
       }
       IconButton(onClick = {}) {
           Icon(imageVector = Icons.Outlined.Notifications,
               contentDescription = "",
               tint = Color.White)
       }




   }
}

@Composable
fun Content(){
    Column() {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
    }
}


@Composable
fun Header() {
    Card(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            QrButton()
            VerticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = "",
                    tint = Color(0xFF6FCF97)
                    )
                Column(modifier = Modifier.padding(8.dp)){
                    Text(text = "$120", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Top Up", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                }
            }

            VerticalDivider()


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
                Column(modifier = Modifier.padding(8.dp)){
                    Text(text = "$10", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Points", color = Color.LightGray, fontSize = 12.sp)
                }
            }

        }

    }
}

@Composable
fun QrButton(){
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
        ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        
    }
}
@Composable
fun VerticalDivider(){
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun Promotions(){
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
    item {
        PromotionItem(
            imagePainter = painterResource(id = R.drawable.promotion),
            title = "Fruit",
            subtitle = "Start @",
            header = "$1",
            backgroundColor = MaterialTheme.colorScheme.primary
        )
    }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.promotion),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xff6EB6F5)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter,
){
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(backgroundColor),
        elevation = CardDefaults.cardElevation(0.dp)
    ){

        Row{
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ){
              Text(text = title, fontSize = 14.sp, color = Color.White)
              Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold )
              Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }

            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }

    }

}

@Composable
fun CategorySection() {
    Column(Modifier.padding(horizontal = 16.dp)){
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Category", style = MaterialTheme.typography.bodyLarge)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colorScheme.primary)
            }

        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            CategoryButton(
                text = "Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(
                text = "Vegetables",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xffF6FBF3)
            )
            CategoryButton(
                text = "Dairy",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xffFFFBF3)
            )
            CategoryButton(
                text = "Meats",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xffF6E6E9)
            )

        }

    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ){

            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp )

    }
}

@Composable
fun BestSellerSection() {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Best Sellers", style = MaterialTheme.typography.bodyLarge)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colorScheme.primary)
            }
        }

        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_lettuce),
                title = "Iceberg Lettuce",
                price = "1.99",
                discountPercent = 10
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_apple),
                title = "Apple",
                price = "2.64",
                discountPercent = 5
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_meat),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter
) {

    /*elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)*/
    Card(

        Modifier
            .width(160.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),

    ){
        Column(
            Modifier
                .padding(bottom = 32.dp)
        )
        {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
                )

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row{
                    Text(
                        text = "$${price}",
                        textDecoration = if (discountPercent >0)
                        TextDecoration.LineThrough
                        else
                        TextDecoration.None,
                        color = if (discountPercent > 0) Color.Gray else Color.Black
                    )
                    if (discountPercent > 0) {
                        Text(text = "[$discountPercent%]", color = MaterialTheme.colorScheme.primary)
                    }
                }


            }


        }

    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryShopTheme {
        HomeScreen()
    }
}